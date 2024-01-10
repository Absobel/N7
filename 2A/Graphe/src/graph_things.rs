use petgraph::Graph;

pub fn avg_degree(graph: &Graph<(), ()>) -> f64 {
    let mut total_degree = 0;
    for node in graph.node_indices() {
        total_degree += graph.neighbors(node).count();
    }
    total_degree as f64 / graph.node_count() as f64
}