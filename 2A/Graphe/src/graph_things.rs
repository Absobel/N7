use anyhow::Result;
use petgraph::Graph;
use plotters::coord::Shift;
use plotters::prelude::*;

use crate::utils::*;
use crate::SatAnalysis;

pub fn avg_degree(graph: &Graph<(), ()>) -> f64 {
    let total_degree: usize = graph
        .node_indices()
        .map(|node| graph.neighbors(node).count())
        .sum();
    total_degree as f64 / graph.node_count() as f64
}

pub fn degree_distribution(graph: &Graph<(), ()>) -> Vec<usize> {
    let degrees = graph
        .node_indices()
        .map(|node| graph.neighbors(node).count())
        .collect::<Vec<_>>();
    degrees
}

impl SatAnalysis {
    pub fn avg_degree(&self) -> (f64, f64, f64) {
        (
            avg_degree(&self.graph_20k),
            avg_degree(&self.graph_40k),
            avg_degree(&self.graph_60k),
        )
    }

    pub fn degree_distribution(&self) -> (Vec<usize>, Vec<usize>, Vec<usize>) {
        (
            degree_distribution(&self.graph_20k),
            degree_distribution(&self.graph_40k),
            degree_distribution(&self.graph_60k),
        )
    }

    pub fn histogram_distrib_degree(self, image_name: &str) -> Result<String> {
        let path = &image_name_to_path(image_name);
        let data = self.degree_distribution();
        let root_area = BitMapBackend::new(&path, (WIDTH, HEIGHT)).into_drawing_area();
        root_area.fill(&WHITE)?;
        let upper_area = root_area
            .clone()
            .shrink((WIDTH / 4, 0), (WIDTH / 2, HEIGHT / 2));
        let lower_left_area = root_area
            .clone()
            .shrink((0, HEIGHT / 2), (WIDTH / 2, HEIGHT / 2));
        let lower_right_area = root_area.shrink((WIDTH / 2, HEIGHT / 2), (WIDTH / 2, HEIGHT / 2));
        let areas = (upper_area, lower_left_area, lower_right_area);

        let draw = |area: &DrawingArea<BitMapBackend<'_>, Shift>,
                    data: Vec<usize>,
                    caption|
         -> Result<()> {
            let x_spec = 0..(data.len()-1);
            let y_spec = 0..*data.iter().max().unwrap();

            let mut chart_builder = ChartBuilder::on(area);
            chart_builder
                .margin(5)
                .caption(format!("{image_name} : {caption}"), ("sans-serif", 30))
                .set_left_and_bottom_label_area_size(20);
            let mut chart_context =
                chart_builder.build_cartesian_2d(x_spec, y_spec)?;
            chart_context.configure_mesh().draw().unwrap();
            chart_context.draw_series(
                Histogram::vertical(&chart_context)
                    .style(RED.filled())
                    .margin(10)
                    .data(data.iter().enumerate().map(|(x, y)| (x, *y))),
            )?;
            Ok(())
        };

        draw(&areas.0, data.0, "20k")?;
        draw(&areas.1, data.1, "40k")?;
        draw(&areas.2, data.2, "60k")?;

        Ok(path.clone())
    }
}
