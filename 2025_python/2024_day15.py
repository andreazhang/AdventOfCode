from utils import *

input = """########
#..O.O.#
##@.O..#
#...O..#
#.#.O..#
#...O..#
#......#
########

<^^>>>vv<v>>v<<"""
input = """
##########
#..O..O.O#
#......O.#
#.OO..O.O#
#..O@..O.#
#O#..O...#
#O..O..O.#
#.OO.O.OO#
#....O...#
##########

<vv>^<v^>v>^vv^v>v<>v^v<v<^vv<<<^><<><>>v<vvv<>^v^>^<<<><<v<<<v^vv^v>^
vvv<<^>^v^^><<>>><>^<<><^vv^^<>vvv<>><^^v>^>vv<>v<<<<v<^v>^<^^>>>^<v<v
><>vv>v^v^<>><>>>><^^>vv>v<^^^>>v^v^<^^>v^^>v^<^v>v<>>v^v^<v>v^^<^^vv<
<<v<^>>^^^^>>>v^<>vvv^><v<<<>^^^vv^<vvv>^>v<^^^^v<>^>vvvv><>>v^<<^^^^^
^><^><>>><>^^<<^^v>>><^<v>^<vv>>v>>>^v><>^v><<<<v>>v<v<v>vvv>^<><<>^><
^>><>^v<><^vvv<^^<><v<<<<<><^v<<<><<<^^<v<^^^><^>>^<v^><<<^>>^v<v^v<v^
>^>>^v>vv>^<<^v<>><<><<v<<v><>v<^vv<<<>^^v^>^^>>><<^v>>v^v><^^>>^<>vv^
<><^^>^^^<><vvvvv^v<v<<>^v<v>v<<^><<><<><<<^^<<<^<<>><<><^^^>^^<>^>v<>
^^>vv<^v^v<vv>^<><v<^v>^^^>>>^^vvv^>vvv<>>>^<^>>>>>^<<^v>^vvv<>^<><<v>
v^^>>><<^^<>>^v^<v^vv<>v^<<>^<^v^v><^<<<><<^<v><v<>vv>>v><v^<vv<>v^<<^"""
input = getInputData(15, 2024)

grid = []
commands = []
startPosition = (0, 0)
wall = '#'
openSpace = '.'
box = 'O'

for line in input.splitlines():
    if line.startswith(wall):
        grid.append(list(line))
    elif line.strip().startswith(('<', '>', '^', 'v')):
        commands.extend(list(line.strip()))

height = len(grid)
width = len(grid[0])

for y, row in enumerate(grid):
    if '@' in row:
        startPosition = (row.index('@'), y)
    print(''.join(row))
print("Commands:", commands)
print("Start position:", startPosition)

def canMoveLeft(x, y):
    for nx in range(x - 1, -1, -1):
        if grid[y][nx] == wall:
            return False
        if grid[y][nx] == openSpace:
            return True

def canMoveRight(x, y):
    for nx in range(x + 1, width):
        if grid[y][nx] == wall:
            return False
        if grid[y][nx] == openSpace:
            return True

def canMoveUp(x, y):
    for ny in range(y - 1, -1, -1):
        if grid[ny][x] == wall:
            return False
        if grid[ny][x] == openSpace:
            return True

def canMoveDown(x, y):
    for ny in range(y + 1, height):
        if grid[ny][x] == wall:
            return False
        if grid[ny][x] == openSpace:
            return True

def moveBoxLeft(x, y):
    for nx in range(x - 1, -1, -1):
        if grid[y][nx] == openSpace:
            grid[y][nx] = box
            break

def moveBoxRight(x, y):
    for nx in range(x + 1, width):
        if grid[y][nx] == openSpace:
            grid[y][nx] = box
            break

def moveBoxUp(x, y):
    for ny in range(y - 1, -1, -1):
        if grid[ny][x] == openSpace:
            grid[ny][x] = box
            break

def moveBoxDown(x, y):
    for ny in range(y + 1, height):
        if grid[ny][x] == openSpace:
            grid[ny][x] = box
            break

for command in commands:
    print("Executing command:", command)
    x, y = startPosition
    if command == '<':
        if (canMoveLeft(x, y)):
            print(f"Moving left from ({x}, {y})")
            x -= 1
            if grid[y][x] == box:
                moveBoxLeft(x, y)
    elif command == '>':
        if (canMoveRight(x, y)):
            print(f"Moving right from ({x}, {y})")
            x += 1
            if grid[y][x] == box:
                moveBoxRight(x, y)
    elif command == '^':
        if (canMoveUp(x, y)):
            print(f"Moving up from ({x}, {y})")
            y -= 1
            if grid[y][x] == box:
                moveBoxUp(x, y)
    elif command == 'v':
        if (canMoveDown(x, y)):
            print(f"Moving down from ({x}, {y})")
            y += 1
            if grid[y][x] == box:
                moveBoxDown(x, y)
    
    grid[startPosition[1]][startPosition[0]] = openSpace
    startPosition = (x, y)
    grid[y][x] = '@'

    print("Grid after executing commands:")
    for row in grid:
        print(''.join(row))

sum = 0
for i, row in enumerate(grid):
    for j, cell in enumerate(row):
        if cell == box:
            sum += 100 * i + j

print("Part 1: Sum of box positions =", sum)