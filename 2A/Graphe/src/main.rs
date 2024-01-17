#![allow(dead_code)]

mod graph_things;
mod satellites;
mod utils;

use satellites::*;
use utils::*;

use anyhow::Result;

const LOW_TOPOLOGY_CSV_PATH: &str = "data/topology_low.csv";
const HIGH_TOPOLOGY_CSV_PATH: &str = "data/topology_high.csv";
const AVG_TOPOLOGY_CSV_PATH: &str = "data/topology_avg.csv";

fn results(csv_path: &str) -> Result<()> {
    let sats = Satellites::from_csv(csv_path)?;
    let sat_a = sats.analyse(format!("{}_graph", fname_from_path(csv_path)).as_str())?;

    open_image(&sat_a.image_path);

    println!("Average degree :");
    print_all_range_res(sat_a.avg_degree());

    println!();

    open_image(&sat_a.histogram_distrib_degree("histogram")?);

    Ok(())
}

fn main() {
    results(AVG_TOPOLOGY_CSV_PATH).unwrap();
}
