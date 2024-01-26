use petgraph::algo::tarjan_scc;
use petgraph::prelude::*;

use crate::utils::*;
use crate::SatAnalysis;

fn degree_distribution(graph: &Graph<(), ()>) -> Vec<usize> {
    let degrees = graph
        .node_indices()
        .map(|node| graph.neighbors(node).count())
        .collect::<Vec<_>>();
    degrees
}

fn clustering_coefficient(graph: &Graph<(), ()>, node_idx: NodeIndex) -> f64 {
    let neighbors = graph.neighbors(node_idx).collect::<Vec<_>>();
    let mut edges = 0;
    for i in 0..neighbors.len() {
        for j in i + 1..neighbors.len() {
            if graph
                .find_edge_undirected(neighbors[i], neighbors[j])
                .is_some()
            {
                edges += 1;
            }
        }
    }
    let degree = neighbors.len();
    if degree > 1 {
        2.0 * edges as f64 / (degree * (degree - 1)) as f64
    } else {
        0.0
    }
}

fn clustering_coefficient_distrib(graph: &Graph<(), ()>) -> Vec<f64> {
    graph
        .node_indices()
        .map(|node| clustering_coefficient(graph, node))
        .collect::<Vec<_>>()
}

fn connected_components(graph: &Graph<(), ()>) -> (usize, Vec<usize>) {
    let components = tarjan_scc(graph).into_iter().filter(|v| v.len() > 1).collect::<Vec<Vec<NodeIndex>>>();
    (components.len(), components.iter().map(|c| c.len()).collect())
}

impl SatAnalysis {
    pub fn map_graphs<F, U>(&self, f: F) -> SatResult<U>
    where
        F: Fn(&Graph<(), ()>) -> U,
    {
        SatResult(f(&self.graph_20k), f(&self.graph_40k), f(&self.graph_60k))
    }

    pub fn degree_distribution(&self) -> SatResult<Vec<usize>> {
        self.map_graphs(degree_distribution)
    }

    pub fn clustering_coefficient_distrib(&self) -> SatResult<Vec<f64>> {
        self.map_graphs(clustering_coefficient_distrib)
    }

    pub fn connected_components(&self) -> SatResult<(usize, Vec<usize>)> {
        self.map_graphs(connected_components)
    }
}
