use std::{fmt::Debug, fs, process::Command};

use crate::satellites::Point;

pub const WIDTH: u32 = 1600;
pub const HEIGHT: u32 = 900;
pub const MARGIN_TOP: u32 = 0;
pub const MARGIN_BOTTOM: u32 = 0;
pub const MARGIN_LEFT: u32 = 20;
pub const MARGIN_RIGHT: u32 = 0;
pub const HEIGHT_DE_FACTO: u32 = HEIGHT - MARGIN_TOP - MARGIN_BOTTOM;
pub const WIDTH_DE_FACTO: u32 = WIDTH - MARGIN_LEFT - MARGIN_RIGHT;

pub fn open_image(path: &str) {
    Command::new("feh")
        .args([path])
        .spawn()
        .expect("failed to execute feh");
}

pub fn min_max_ranges_points(
    points: &[Point],
) -> (
    std::ops::Range<f64>,
    std::ops::Range<f64>,
    std::ops::Range<f64>,
) {
    let (min_x, max_x, min_y, max_y, min_z, max_z) = points
        .iter()
        .fold(None, |acc, &point| match acc {
            None => Some((point.x, point.x, point.y, point.y, point.z, point.z)),
            Some((min_x, max_x, min_y, max_y, min_z, max_z)) => Some((
                min_x.min(point.x),
                max_x.max(point.x),
                min_y.min(point.y),
                max_y.max(point.y),
                min_z.min(point.z),
                max_z.max(point.z),
            )),
        })
        .unwrap();
    (min_x..max_x, min_y..max_y, min_z..max_z)
}

pub struct SatResult<T>(pub T, pub T, pub T);

impl<T> SatResult<T> {
    pub fn apply_enum_range(&self, f: impl Fn(usize, &T)) {
        f(20, &self.0); f(40, &self.1); f(60, &self.2);
    }
}

impl<T: Debug> SatResult<T> {
    pub fn print_all_range_res(&self) {
        println!("20k : {:?}", self.0);
        println!("40k : {:?}", self.1);
        println!("60k : {:?}", self.2);
    }
}

impl SatResult<Vec<usize>> {
    pub fn avg(&self) -> SatResult<f64> {
        SatResult(
            self.0.iter().sum::<usize>() as f64 / self.0.len() as f64,
            self.1.iter().sum::<usize>() as f64 / self.1.len() as f64,
            self.2.iter().sum::<usize>() as f64 / self.2.len() as f64,
        )
    }
}

impl SatResult<Vec<f64>> {
    pub fn avg(&self) -> SatResult<f64> {
        SatResult(
            self.0.iter().sum::<f64>() / self.0.len() as f64,
            self.1.iter().sum::<f64>() / self.1.len() as f64,
            self.2.iter().sum::<f64>() / self.2.len() as f64,
        )
    }
}

pub fn fname_from_path(path: &str) -> String {
    path.split('/')
        .last()
        .unwrap()
        .split('.')
        .next()
        .unwrap()
        .to_string()
}

pub fn image_name_to_path(image_name: &str) -> String {
    fs::create_dir_all("target/images").unwrap();
    format!("target/images/{}.png", image_name)
}
