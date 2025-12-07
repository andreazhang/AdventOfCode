from utils import *

input = """
p=0,4 v=3,-3
p=6,3 v=-1,-3
p=10,3 v=-1,2
p=2,0 v=2,-1
p=0,0 v=1,3
p=3,0 v=-2,-2
p=7,6 v=-1,-3
p=3,0 v=-1,-2
p=9,3 v=2,3
p=7,3 v=-1,2
p=2,4 v=2,-3
p=9,5 v=-3,-3
"""
width = 11
height = 7
input = getInputData(14, 2024)
width = 101
height = 103

lines = input.strip().splitlines()
print("# of robots:", len(lines))
robots = []
for line in lines:
    parts = line.split()
    positionPart = parts[0][2:]
    velocityPart = parts[1][2:]
    position = tuple(int(x) for x in positionPart.split(','))
    velocity = tuple(int(x) for x in velocityPart.split(','))
    robots.append((position, velocity))
# print(robots)

def moveRobot(position, velocity, seconds=1):
    if velocity[0] > 100 or velocity[1] > 100:
        print("Large velocity:", velocity)
    newX = position[0] + velocity[0]
    newY = position[1] + velocity[1]
    if newX < 0:
        newX += width
    elif newX >= width:
        newX -= width
    if newY < 0:
        newY += height
    elif newY >= height:
        newY -= height
    newPosition = (newX, newY)
    if (seconds == 1):
        return newPosition
    # print("Moving to", newPosition, "with", seconds - 1, "seconds left")
    return moveRobot(newPosition, velocity, seconds - 1)

newRobots = []
for robot in robots:
    newPosition = moveRobot(robot[0], robot[1], 100)
    # print("Robot at", robot[0], "with velocity", robot[1], "after 5 seconds is at", newPosition)
    newRobots.append((newPosition, robot[1]))

print("# of robots after 100 seconds:", len(newRobots))

def gridRobots(robots, width=width, height=height):
    grid = [[[] for _ in range(width)] for _ in range(height)]
    for robot in robots:
        # print("Robot at", robot[0], "with velocity", robot[1])
        if grid[robot[0][1]][robot[0][0]] == []:
            grid[robot[0][1]][robot[0][0]] = 1
        else:
            grid[robot[0][1]][robot[0][0]] += 1

    # for line in grid:
    #     print(line)

    for y in range(height):
        for x in range(width):
            if grid[y][x] == []:
                grid[y][x] = '.'
            else:
                grid[y][x] = str(grid[y][x])
    return grid

def printRobots(robots):
    grid = gridRobots(robots, width, height)

    for line in grid:
        print(' '.join(line))

# printRobots(robots)

# print("After 100 seconds:")
# printRobots(newRobots)

grid = gridRobots(newRobots)

# for line in grid:
#     print((line))

quadrants = [[] for _ in range(4)]

for i in range(height):
    for j in range(width):
        if grid[i][j] != '.':
            if i < height // 2 and j < width // 2:
                quadrants[0].append(int(grid[i][j]))
            elif i < height // 2 and j > width // 2:
                quadrants[1].append(int(grid[i][j]))
            elif i > height // 2 and j < width // 2:
                quadrants[2].append(int(grid[i][j]))
            elif i > height // 2 and j > width // 2:
                quadrants[3].append(int(grid[i][j]))

for line in quadrants:
    print(line)

factor = 1
for quadrant in quadrants:
    sum = 0
    for number in quadrant:
        sum += number
    # print("Quadrant product:", sum)
    factor *= sum

assert factor != 224020368 # too high
print("Part 1 solution:", factor)