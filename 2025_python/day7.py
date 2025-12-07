from utils import *

input = """.......S.......
...............
.......^.......
...............
......^.^......
...............
.....^.^.^.....
...............
....^.^...^....
...............
...^.^...^.^...
...............
..^...^.....^..
...............
.^.^.^.^.^...^.
..............."""
# input = getInputData(7)

startPoint = 0

grid = []
for line in input.splitlines():
    startPoint = line.index('S') if 'S' in line else startPoint
    grid.append(list(line))

height = len(grid)
width = len(grid[0])

print("Start point at x =", startPoint)
for line in grid:
    print(''.join(line))

def moveTachyonBeamDownAndCountSplits(grid, x, y):
    # print("Moving tachyon beam to", x, y)
    if y >= height:
        return 0
    if grid[y][x] == '.':
        grid[y][x] = '|'
        return moveTachyonBeamDownAndCountSplits(grid, x, y + 1)
    elif grid[y][x] == '^':
            grid[y][x-1] = '|'
            grid[y][x+1] = '|'
            return 1 + moveTachyonBeamDownAndCountSplits(grid, x - 1, y + 1) + moveTachyonBeamDownAndCountSplits(grid, x + 1, y + 1)
    return 0

numberOfTachyonBeamsSplits = moveTachyonBeamDownAndCountSplits(grid, startPoint, 1)

print("Grid after moving tachyon beam:")
for line in grid:
    print(''.join(line))

print("Part 1: Number of tachyon beams splits =", numberOfTachyonBeamsSplits)

grid = []
for line in input.splitlines():
    startPoint = line.index('S') if 'S' in line else startPoint
    grid.append(list(line))

for line in grid:
    print(''.join(line))

print("Filling grid with tachyon beam counts...")

for y, line in enumerate(grid):
    for x, cell in enumerate(line):
        if cell == 'S':
            grid[y+1][x] = 1
        if isinstance(cell, int):
            if y < height - 1 and grid[y+1][x] == '.':
                grid[y+1][x] = cell
            elif y < height - 1 and isinstance(grid[y+1][x], int):
                grid[y+1][x] += cell
            elif y < height - 1 and grid[y+1][x] == '^':
                if y < height - 1 and grid[y+1][x-1] == '.':
                    grid[y+1][x-1] = 0
                if y < height - 1 and grid[y+1][x+1] == '.':
                    grid[y+1][x+1] = 0
                grid[y+1][x-1] += cell
                grid[y+1][x+1] += cell

for line in grid:
    string = ""
    for cell in line:
        string += str(cell)
    print(string)

totalPaths = 0
for cell in grid[height-1]:
    if isinstance(cell, int):
        totalPaths += cell

print("Part 2: Total number of paths for tachyon beam to reach bottom =", totalPaths)
