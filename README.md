# TDT4250 - Advanced Software Engineering - Assignment 2

**Remark: README will be updated with more information later..**

This project is built as a modular, flexible OSGi project og a unit conversion system.

## Setup

The root project and folder was created using the BndTools' Bnd OSGi Workspace wizard, and each bundle with the Bnd OSGi Project wizard. Which bundle template to use depends on the specific bundle, there are api, component and servlet bundles in this project.

To make your own OSGi project with a similar structure, it's best to start with a fresh Eclipse workspace, create a Bnd OSGi Workspace there and the bundles one by one, making sure to "guess" the right template to use. To be able to glance at this example while working on your own, open the example workspace in a different Eclipse installation, since it's difficult to open the same Eclipse one different workspaces simultaneously.

To run the project, you should open the launch.bndrun file in the servlet bundle, make sure it resolves and use Run OSGi. You can try various commands in the gogo shell, e.g. felix:lb to see which bundles are in which states or scr:list to se the active components, and do a dictionary lookup using http://localhost:8080/unit/{conversion}?q={number} in a browser (e.g.localhost:8080/unit/kmtomiles?q=10)

## Bundles and packages

- tdt4250.unit.api: Describe
- tdt4250.unit.servlet: Describe
- tdt4250.unit.util: Describe
- tdt4250.unit.gogo: Gogo shell commands for managing **Unit** service components.

## Core conversions

- Km to miles
- Miles to km
- Celsius to Fahrenheit
- Fahrenheit to Celsius
- Pounds to kg
- Kg to pounds

## Adding new conversions:

When adding new conversions, they need to use x as paramter. One example of conversion equation is x\*0.4324.
