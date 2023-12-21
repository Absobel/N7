use plotters::{backend::BitMapBackend, drawing::IntoDrawingArea, chart::ChartBuilder, style::WHITE};

pub struct Satellites {
    x: Vec<f64>,
    y: Vec<f64>,
    z: Vec<f64>,
}

impl Satellites {
    pub fn from_csv(csv_path: &str) -> Result<Self, csv::Error> {
        let mut x = Vec::new();
        let mut y = Vec::new();
        let mut z = Vec::new();

        let mut reader = csv::Reader::from_path(csv_path).unwrap();
        for record in reader.records() {
            let record = record?;
            x.push(record[0].parse().unwrap());
            y.push(record[1].parse().unwrap());
            z.push(record[2].parse().unwrap());
        }

        Ok(Self { x, y, z })
    }

    pub fn plot(&self) -> Result<(), Box<dyn std::error::Error>> {
        let root_area = BitMapBackend::new("target/satellites.png", (1024, 768)).into_drawing_area();
        root_area.fill(&WHITE)?;

        fn min_max_range(values: &[f64]) -> std::ops::Range<f64> {
            let (min, max) = values.iter().fold(None, |acc, &val| {
                match acc {
                    None => Some((val, val)),
                    Some((min, max)) => Some((min.min(val), max.max(val))),
                }
            }).unwrap();
            min..max
        }

        let mut ctx = ChartBuilder::on(&root_area)
            .margin(20)
            .caption("Satellites", ("sans-serif", 50))
            .build_cartesian_3d(min_max_range(&self.x), min_max_range(&self.y), min_max_range(&self.z))?;

        ctx.configure_axes().draw()?;
        ctx.draw_series(self.x.iter().zip(self.y.iter()).zip(self.z.iter()).map(|((x, y), z)| {
            plotters::prelude::Cross::new((*x, *y, *z), 5, plotters::style::BLACK)
        }))?;
        Ok(())
    }
}