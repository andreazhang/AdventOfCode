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

numberOfTachyonBeams = 0

def moveTachyonBeamDown(grid, x, y):
    # print("Moving tachyon beam to", x, y)
    counter = 0
    if y >= height:
        return counter
    if grid[y][x] == '.':
        grid[y][x] = '|'
        return counter + moveTachyonBeamDown(grid, x, y + 1)
    elif grid[y][x] == '^':
            grid[y][x-1] = '|'
            grid[y][x+1] = '|'
            return counter + 1 + moveTachyonBeamDown(grid, x - 1, y+1) + moveTachyonBeamDown(grid, x + 1, y+1)
    return 0

numberOfTachyonBeams = moveTachyonBeamDown(grid, startPoint, 1)

print("Grid after moving tachyon beam:")
for line in grid:
    print(''.join(line))

print("Part 1: Number of tachyon beams encountered =", numberOfTachyonBeams)