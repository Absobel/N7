use plotters::{prelude::*, coord::Shift};

use crate::utils::{min_max_ranges_points, HEIGHT, WIDTH};

#[derive(Clone, Copy, PartialEq)]
pub struct Point {
    pub x: f64,
    pub y: f64,
    pub z: f64,
}

impl Point {
    fn new(x: f64, y: f64, z: f64) -> Self {
        Self { x, y, z }
    }

    fn distance(&self, other: &Self) -> f64 {
        ((self.x - other.x).powi(2) + (self.y - other.y).powi(2) + (self.z - other.z).powi(2))
            .sqrt()
    }
}

pub struct Satellites {
    points: Vec<Point>,
}

impl Satellites {
    pub fn from_csv(csv_path: &str) -> Result<Self, csv::Error> {
        let mut points = Vec::new();

        let mut reader = csv::Reader::from_path(csv_path).unwrap();
        for record in reader.records() {
            let record = record?;
            let x = record[1].parse::<f64>().unwrap();
            let z = record[2].parse::<f64>().unwrap();
            let y = record[3].parse::<f64>().unwrap();
            points.push(Point::new(x, y, z));
        }

        Ok(Self { points })
    }

    /// Plots the satellites in 3D space and returns the path to the image.
    pub fn plot(&self, image_name: &str) -> Result<String, Box<dyn std::error::Error>> {
        let ranges = min_max_ranges_points(&self.points);

        let plot_points_iter = self
            .points
            .iter()
            .map(|point| Cross::new((point.x, point.y, point.z), 5, plotters::style::BLACK));

        let mut plot_20k_iter = vec![];
        let mut plot_40k_iter = vec![];
        let mut plot_60k_iter = vec![];

        for (i, point1) in self.points.iter().enumerate() {
            for (j, point2) in self.points.iter().enumerate() {
                if i >= j {
                    continue;
                }

                let distance = point1.distance(point2);
                let path_element = PathElement::new(
                    vec![
                        (point1.x, point1.y, point1.z),
                        (point2.x, point2.y, point2.z),
                    ],
                    BLACK,
                );

                if distance <= 20_000.0 {
                    plot_20k_iter.push(path_element);
                } else if distance <= 40_000.0 {
                    plot_40k_iter.push(path_element);
                } else if distance <= 60_000.0 {
                    plot_60k_iter.push(path_element);
                }
            }
        }

        let path = format!("target/{image_name}.png");
        let root_area = BitMapBackend::new(&path, (WIDTH, HEIGHT)).into_drawing_area();
        root_area.fill(&WHITE)?;
        let upper_area = root_area.clone().shrink((0, 0), (WIDTH, HEIGHT / 2));
        let lower_left_area = root_area
            .clone()
            .shrink((0, HEIGHT / 2), (WIDTH / 2, HEIGHT / 2));
        let lower_right_area = root_area.shrink((WIDTH / 2, HEIGHT / 2), (WIDTH / 2, HEIGHT / 2));
        let areas = (upper_area, lower_left_area, lower_right_area);

        #[allow(non_snake_case)]
        let draw = |area: &DrawingArea<BitMapBackend<'_>, Shift>,
                    plot_XXk_iter: Vec<PathElement<(f64, f64, f64)>>,
                    caption|
         -> Result<(), Box<dyn std::error::Error>> {
            let mut ctx = ChartBuilder::on(area)
                .margin(20)
                .caption(format!("{image_name} : {caption}"), ("sans-serif", 30))
                .build_cartesian_3d(ranges.0.clone(), ranges.1.clone(), ranges.2.clone())?;

            ctx.configure_axes().draw()?;
            ctx.draw_series(plot_points_iter.clone())?;
            ctx.draw_series(plot_XXk_iter)?;
            Ok(())
        };

        draw(&areas.0, plot_20k_iter, "20k").unwrap();
        draw(&areas.1, plot_40k_iter, "40k").unwrap();
        draw(&areas.2, plot_60k_iter, "60k").unwrap();

        Ok(path.clone())
    }
}