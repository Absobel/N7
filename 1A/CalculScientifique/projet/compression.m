close all; clear all;

image_a_comp = imread('fournitures/BD_Asterix_0.png');
image_a_comp = double(rgb2gray(image_a_comp));

image_compressee = image_compression_method2(@eig, image_a_comp, 100);

image(image_compressee)