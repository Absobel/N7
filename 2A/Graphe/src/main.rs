#![allow(dead_code)]

mod satellites;
mod utils;
mod graph_things;

use satellites::*;
use utils::*;
use graph_things::*;

const LOW_TOPOLOGY_CSV_PATH: &str = "data/topology_low.csv";
const HIGH_TOPOLOGY_CSV_PATH: &str = "data/topology_high.csv";
const AVG_TOPOLOGY_CSV_PATH: &str = "data/topology_avg.csv";

fn main() {
    let avg_sats = Satellites::from_csv(AVG_TOPOLOGY_CSV_PATH).unwrap();
    let avg_sat_a = avg_sats.analyse("avg_sats").unwrap();

    // let low_sats = Satellites::from_csv(LOW_TOPOLOGY_CSV_PATH).unwrap();
    // let low_sat_a = low_sats.analyse("low_sats").unwrap();

    // let high_sats = Satellites::from_csv(HIGH_TOPOLOGY_CSV_PATH).unwrap();
    // let high_sat_a = high_sats.analyse("high_sats").unwrap();

    open_image(&avg_sat_a.image_path);
    // open_image(&low_sat_a.image_path);
    // open_image(&high_sat_a.image_path);

    println!("Avg degree: {}", avg_degree(&avg_sat_a.graph_20k));
    println!("Avg degree: {}", avg_degree(&avg_sat_a.graph_40k));
    println!("Avg degree: {}", avg_degree(&avg_sat_a.graph_60k));
}
