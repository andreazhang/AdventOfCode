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