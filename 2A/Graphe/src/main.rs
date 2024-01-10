#![allow(dead_code)]

mod satellites;
mod utils;

use satellites::*;
use utils::*;

const LOW_TOPOLOGY_CSV_PATH: &str = "data/topology_low.csv";
const HIGH_TOPOLOGY_CSV_PATH: &str = "data/topology_high.csv";
const AVG_TOPOLOGY_CSV_PATH: &str = "data/topology_avg.csv";

fn main() {
    let avg_sats = Satellites::from_csv(AVG_TOPOLOGY_CSV_PATH).unwrap();
    let path_avg = avg_sats.plot("avg_sats").unwrap();

    // let low_sats = Satellites::from_csv(LOW_TOPOLOGY_CSV_PATH).unwrap();
    // let path_low = low_sats.plot("low_sats").unwrap();

    // let high_sats = Satellites::from_csv(HIGH_TOPOLOGY_CSV_PATH).unwrap();
    // let path_high = high_sats.plot("high_sats").unwrap();

    // open_image(&path_low);
    // open_image(&path_high);
    open_image(&path_avg);
}
