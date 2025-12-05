from utils import *

input = """..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@."""
input = getInputData(4)

grid = []

maxAdjacentRolls = 4 # Not inclusive

for line in input.splitlines():
    grid.append(list(line.strip()))

def getAdjacentRolls(i, j, grid):
    adjacentRolls = []
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]  # up, down, left, right
    for di, dj in directions:
        ni, nj = i + di, j + dj
        if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]):
            if grid[ni][nj] == '@':
                adjacentRolls.append((ni, nj))
    return len(adjacentRolls)

def liftRolls(grid):
    liftableRolls = []
    for i, row in enumerate(grid):
        print(row)
        for j, cell in enumerate(row):
            if cell == '@':
                adjacentRolls = getAdjacentRolls(i, j, grid)
                # print(f"Cell ({i}, {j}) has adjacent rolls: {adjacentRolls}")
                if adjacentRolls < maxAdjacentRolls:
                    liftableRolls.append((i, j))
    for i, j in liftableRolls:
        grid[i][j] = 'x'
    print("---- After Lifting ----")
    for row in grid:
        print(row)
    if (len(liftableRolls) > 0):
        return len(liftableRolls) + liftRolls(grid)
    return len(liftableRolls)

liftedRolls = liftRolls(grid)
print(f"Total lifted rolls: {liftedRolls}")

