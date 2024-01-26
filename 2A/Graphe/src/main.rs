#[allow(dead_code)]
mod graph_things;
mod satellites;
mod utils;

use satellites::*;
use utils::*;

use anyhow::{Ok, Result};

const LOW_TOPOLOGY_CSV_PATH: &str = "data/topology_low.csv";
const HIGH_TOPOLOGY_CSV_PATH: &str = "data/topology_high.csv";
const AVG_TOPOLOGY_CSV_PATH: &str = "data/topology_avg.csv";

fn degree(sat_a: &SatAnalysis, images: &mut Vec<String>, histo_image_name: &str) -> Result<()> {
    let degrees = sat_a.degree_distribution();

    println!("Average degree :");
    degrees.avg().print_all_range_res();

    let hist_dd_image_path = sat_a.histogram_degree_distrib(degrees, histo_image_name)?;
    images.push(hist_dd_image_path);

    Ok(())
}

fn clustering_degree(
    sat_a: &SatAnalysis,
    images: &mut Vec<String>,
    histo_image_name: &str,
) -> Result<()> {
    let clustering_coefficients = sat_a.clustering_coefficient_distrib();

    println!("Avg clustering coeff :");
    clustering_coefficients.avg().print_all_range_res();

    let hist_cc_image_path =
        sat_a.histogram_coeff_clustering(clustering_coefficients, histo_image_name)?;
    images.push(hist_cc_image_path);

    Ok(())
}

fn connected_components(sat_a: &SatAnalysis) {
    let comp = sat_a.connected_components();
    comp.apply_enum_range(|r, (nb, vsize)| {
        println!("{r}k : {nb} composantes connexes | tailles {:?}", vsize)
    })
}

fn results(csv_path: &str) -> Result<()> {
    let sats = Satellites::from_csv(csv_path)?;
    let sat_a = sats.analyse(format!("{}_graph", fname_from_path(csv_path)).as_str())?;

    let mut images: Vec<String> = vec![];

    /////////////// THINGS

    images.push(sat_a.image_path.clone());
    degree(&sat_a, &mut images, "distribution du degré")?;
    println!();
    clustering_degree(&sat_a, &mut images, "distribution du degré de clustering")?;
    println!();
    connected_components(&sat_a);

    /////////////// IMAGES

    images
        .into_iter()
        .for_each(|image| open_image(image.as_str()));

    Ok(())
}

fn main() {
    // results(LOW_TOPOLOGY_CSV_PATH).unwrap();
    results(AVG_TOPOLOGY_CSV_PATH).unwrap();
    // results(HIGH_TOPOLOGY_CSV_PATH).unwrap();
}
