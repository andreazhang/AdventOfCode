from utils import *

input = """123 328  51 64 
 45 64  387 23 
  6 98  215 314
*   +   *   +  
"""
input = getInputData(6)

lines = input.strip().splitlines()
height = len(lines)
width = len(lines[0].split())

grid = []
for line in lines:
    row = []
    for part in line.split():
        row.append(part.strip())
    grid.append(row)

# print(grid)
print("grid size:", height, "x", width)

problemSolution = 0

for x in range(width):
    problemNumbers = []
    problemOperation = None
    problemResult = 0
    for y in range(height):
        if grid[y][x] not in ['*', '+']:
            problemNumbers.append(int(grid[y][x]))
        else:
            problemOperation = grid[y][x]
    if problemOperation == '*':
        problemResult = 1
        for number in problemNumbers:
            problemResult *= number
    elif problemOperation == '+':
        for number in problemNumbers:
            problemResult += number
    problemSolution += problemResult

print("Part 1 solution:", problemSolution)

lines = input.splitlines()
# print(lines)

problemNumbers = []
problemSolution = 0
for i in range(len(lines[0])-1, -1, -1):
    # print(" char", i)
    numberStr = ""
    problemOperation = None
    problemResult = 0
    for line in lines:
        # print("line:", line[i])
        if line[i] != ' ' and line[i] != '*' and line[i] != '+':
            numberStr += line[i]
        elif line[i] == '*' or line[i] == '+':
            problemOperation = line[i]
    if numberStr == "":
        continue
    # print("numberStr:", numberStr)
    problemNumbers.append(int(numberStr))
    # print("problemNumbers:", problemNumbers)
    if problemOperation is not None:
        if problemOperation == '*':
            problemResult = 1
            for number in problemNumbers:
                problemResult *= number
        elif problemOperation == '+':
            problemResult = 0
            for number in problemNumbers:
                problemResult += number
        # print("problemResult:", problemResult)
        problemSolution += problemResult
        problemNumbers = []

assert problemSolution != 7292291765481871 # too high
print("Part 2 solution:", problemSolution)