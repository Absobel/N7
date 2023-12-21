#![allow(dead_code)]

use std::{fs::File, io::Write, process::Command};

pub fn dot_to_png(dot_str: &str, png_output_path: &str) {
    let mut file = File::create("target/graph.dot").unwrap();
    file.write_all(dot_str.as_bytes()).unwrap();

    Command::new("dot")
        .args(["-Tpng", "target/graph.dot", "-o", png_output_path])
        .output()
        .expect("failed to execute Graphviz");
}

pub fn open_image(path: &str) {
    Command::new("feh")
        .args([path])
        .output()
        .expect("failed to execute feh");
}
