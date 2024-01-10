use std::process::Command;

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
