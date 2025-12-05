from utils import *

input = """
AAAA
BBCD
BBCC
EEEC
"""
input = """
OOOOO
OXOXO
OOOOO
OXOXO
OOOOO
"""
input = """
RRRRIICCFF
RRRRIICCCF
VVRRRCCFFF
VVRCCCJFFF
VVVVCJJCFE
VVIVCCJJEE
VVIIICJJEE
MIIIIIJJEE
MIIISIJEEE
MMMISSJEEE
"""
input = getInputData(12, 2024)

grid = []

for line in input.splitlines():
    if line.strip() == "":
        continue
    grid.append(list(line.strip()))

print("Initial Grid:", grid)
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # up, down, left, right

def calculatePrice(grid, i, j, seenCells, block):
    cellKey = (i, j)
    seenCells.add(cellKey)

    cell = grid[i][j]
    block[0] += 1

    for di, dj in directions:
        ni, nj = i + di, j + dj
        if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]):
            neighborCell = grid[ni][nj]
            # print(f"Checking neighbor cell ({ni}, {nj}) with value '{neighborCell}'")
            if neighborCell != cell:
                # print(f"Cell ({ni}, {nj}) with value '{neighborCell}' is different from '{cell}'")
                block[1] += 1
            else:
                neighborKey = (ni, nj)
                if neighborKey not in seenCells:
                    # print(f"Visiting neighbor cell ({ni}, {nj}) with value '{neighborCell}'")
                    calculatePrice(grid, ni, nj, seenCells, block)
        else:
            # print(f"Cell ({i}, {j}) is at the edge, adding to perimeter")
            block[1] += 1

    # price += area * perimeter
    # print(f"--- {cell} = {price} - Area: {area}, Perimeter: {perimeter}")

    return

def deleteSeenCells(grid, seenCells):
    for (i, j) in seenCells:
        grid[i][j] = '.'

totalPrice = 0
for line in grid:
    for cell in line:
        if cell != '.':
            seen = set()
            block = [0, 0]
            calculatePrice(grid, grid.index(line), line.index(cell), seen, block)
            price = block[0] * block[1]
            totalPrice += price
            print(f"Price for cell '{cell}': {price} (Area: {block[0]}, Perimeter: {block[1]})")
            deleteSeenCells(grid, seen)
            # print("Grid after deletion:", grid)

print(f"Final total price: {totalPrice}")