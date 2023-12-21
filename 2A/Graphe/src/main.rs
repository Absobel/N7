mod utils;
mod satellites;
use std::fs::File;

use csv::Reader;
use utils::*;
use satellites::*;



const LOW_TOPOLOGY_CSV_PATH: &str = "data/topology_low.csv";
const HIGH_TOPOLOGY_CSV_PATH: &str = "data/topology_high.csv";
const AVG_TOPOLOGY_CSV_PATH: &str = "data/topology_avg.csv";

fn main() {
    let low_sats = Satellites::from_csv(LOW_TOPOLOGY_CSV_PATH).unwrap();
    low_sats.plot().unwrap();
    open_image("target/satellites.png");
}
