# Maze-Solver
Java implementation of maze solving algorithms to compare BFS with a queue to DFS with a stack

## Overview
This project implements maze solving algorithms using inheritance and polymorphism. The abstract MazeSolver base class provides common maze-solving functionality, while the subclasses implement different search strategies:

MazeSolverQueue: Implements Breadth-First Search (BFS) - guarantees shortest path
MazeSolverStack: Implements Depth-First Search (DFS) - uses less memory but may not find shortest path

## Maze File Format

Text File with maze dimensions, followed by grid of numbers 0 - 3.

First Line: rows columns

Following Lines:

- 0 = Open Path
- 1 = Wall
- 2 = Start Position
- 3 = Exit Position
