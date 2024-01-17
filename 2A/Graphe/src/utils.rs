use std::{fmt::Debug, fs, process::Command};

use crate::satellites::Point;

pub const WIDTH: u32 = 1920;
pub const HEIGHT: u32 = 1080;

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

pub fn print_all_range_res<T: Debug>(t: (T, T, T)) {
    println!("20k : {:?}", t.0);
    println!("40k : {:?}", t.1);
    println!("60k : {:?}", t.2);
}

pub fn apply_all_ranges_enum<T>(t: (T, T, T), f: impl Fn(usize, T)) {
    f(0, t.0);
    f(1, t.1);
    f(2, t.2);
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
