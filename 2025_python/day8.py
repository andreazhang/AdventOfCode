from utils import *
import math

input = """162,817,812
57,618,57
906,360,560
592,479,940
352,342,300
466,668,158
542,29,236
431,825,988
739,650,466
52,470,668
216,146,977
819,987,18
117,168,530
805,96,715
346,949,466
970,615,88
941,993,340
862,61,35
984,92,344
425,690,689"""
numberOfConnectionsToDo = 10
input = getInputData(8)
numberOfConnectionsToDo = 1000

junctionBoxes = []
for line in input.splitlines():
    parts = line.strip().split(',')
    junctionBoxes.append((int(parts[0]), int(parts[1]), int(parts[2])))

# print("Junction Boxes:", junctionBoxes)

distances = []
for i in range(len(junctionBoxes) - 1):
    for j in range(i + 1, len(junctionBoxes)):
        box1 = junctionBoxes[i]
        box2 = junctionBoxes[j]
        distance = math.sqrt((box1[0] - box2[0]) ** 2 + (box1[1] - box2[1]) ** 2 + (box1[2] - box2[2]) ** 2)
        distances.append((distance, box1, box2))

distances.sort()
# for distance, box1, box2 in distances[:]:
#     print(f"Distance: {distance:.2f} between boxes {box1} and {box2}")

def mergeCircuits(circuits):
    for i in range(len(circuits) - 1):
        for j in range(i + 1, len(circuits)):
            circuit1 = circuits[i]
            circuit2 = circuits[j]
            if any(box in circuit1 for box in circuit2):
                # print(f"Merging circuits: {circuit1} and {circuit2}")
                circuit1.extend(box for box in circuit2 if box not in circuit1)
                del circuits[j]
                mergeCircuits(circuits)
                return True
    return False

# mergeCircuits(circuits)

circuits = []
for distance, box1, box2 in distances[:numberOfConnectionsToDo]:
    # print(f"Processing distance: {distance:.2f} between boxes {box1} and {box2}")
    # print("Current circuits:", circuits)
    for circuit in circuits:
        if box1 in circuit and box2 in circuit:
            break
        elif box1 in circuit:
            circuit.append(box2)
            break
        elif box2 in circuit:
            circuit.append(box1)
            break
    else:
        circuits.append([box1, box2])

mergeCircuits(circuits)

circuits.sort(key=lambda c: len(c), reverse=True)
# print("Final circuits:")
# for circuit in circuits[:10]:
#     print(len(circuit), circuit)

circuitSizes = [len(circuit) for circuit in circuits]
circuitSizes.sort(reverse=True)

print("Top 3 circuit sizes:", circuitSizes[:3])

circuitTotal = 1
for size in circuitSizes[:3]:
    circuitTotal *= size

assert circuitTotal != 8
assert circuitTotal != 2112
assert circuitTotal != 2880
assert circuitTotal != 5865 # too low
assert circuitTotal != 6120 # too low

print("Part 1: Circuit sizes multiplied together =", circuitTotal)

finalCoordinateMultiplication = 0
circuits = []
for distance, box1, box2 in distances[:]:
    # print(f"Processing distance: {distance:.2f} between boxes {box1} and {box2}")
    # print("Current circuits:", circuits)
    circuit1 = []
    circuit2 = []
    for circuit in circuits:
        if box1 in circuit:
            circuit1 = circuit
        if box2 in circuit:
            circuit2 = circuit
    # both are empty so need to add a new circuit
    if not circuit1 and not circuit2:
        circuits.append([box1, box2])
    # both found in same circuit so do nothing
    elif circuit1 and circuit2 and circuit1 == circuit2:
        pass
    # one found so add the other to it
    elif circuit1 and not circuit2:
        circuit1.append(box2)
    elif circuit2 and not circuit1:
        circuit2.append(box1)
    # both found so need to merge circuits
    else:
        # print(f"Merging circuits: {circuit1} and {circuit2}")
        circuit1.extend(box for box in circuit2 if box not in circuit1)
        circuits.remove(circuit2)
        # print(f". Merging boxes: {box1} and {box2} = {len(circuits)} {circuits}")
    if len(circuits[0]) == len(junctionBoxes):
        # print(f"All junction boxes connected! {box1} to {box2} at distance {distance}")
        finalCoordinateMultiplication = box1[0] * box2[0]
        break

print("Part 2: Final coordinate multiplication =", finalCoordinateMultiplication)
    