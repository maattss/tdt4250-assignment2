# TDT4250 - Advanced Software Engineering - Assignment 2

**Remark: README will be updated with more information later..**

This project is built as a modular, flexible OSGi project og a unit conversion system.

## Setup

The root project and folder was created using the BndTools' Bnd OSGi Workspace wizard, and each bundle with the Bnd OSGi Project wizard. Which bundle template to use depends on the specific bundle, there are api, component and servlet bundles in this project.

To run the project, you should open the launch.bndrun file in the servlet bundle, make sure it resolves and use Run OSGi. You can try various commands in the gogo shell, e.g. felix:lb to see which bundles are in which states or scr:list to se the active components, and do a convertion using http://localhost:8080/unit/{conversion}?q={number} in a browser (e.g.localhost:8080/unit/kmtomiles?q=10).

Some conversions are defined as core conversions and included in project (i.e. "Km to miles", "Miles to km", "Celsius to Fahrenheit" and "Fahrenheit to Celsius"). In addition to this, it is possible to add new conversions by developing own components or adding simple ones with the command line tool (further explained below).

## Bundles and packages

The workspace contains of 9 different bundles.

- tdt4250.unit.api: The core interfaces and classes that will be used for convertions.
- tdt4250.unit.servlet: The Servlet component implementing a web service for converting numbers between different units.
- tdt4250.unit.rest: TODO: Describe
- tdt4250.unit.util: Class for managing core convertionsused by all the core convertions currently implemented
- tdt4250.unit.gogo: Gogo shell commands for managing **Unit** service components (described more below).
- tdt4250.unit.kmtomiles: Component for converting distance from **miles** to **kilometers**
- tdt4250.unit.milestokm: Component for converting distance from **miles** to **kilometers**
- tdt4250.unit.celsiustofahrenheit: Component for converting temperature from Celsius to Fahrenheit
- tdt4250.unit.fahrenheittocelsius: Component for converting temperature from Fahrenheit to Celsius

## Gogo shell commands

- `list` - list all active/running conversions
- `convert {conversion name} {number to convert}` - convert between two units. Syntax
- `add {conversion name} {conversion equation}`
- `remove {conversion name}`

## Adding new conversions:

When adding new conversions, they need to use x as paramter. One example of conversion equation is x\*0.4324.
