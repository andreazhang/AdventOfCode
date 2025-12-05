from utils import *

input = """987654321111111
811111111111119
234234234234278
818181911112111"""
input = getInputData(3)

batteryBanks = input.splitlines()
joltageDigits = 12

sum = 0
for batteryBank in batteryBanks:
    joltage = 0
    index = 0
    for digit in range(joltageDigits, 0, -1):
        batteryBankAsArrayOfInt = list(map(int, batteryBank.strip()))
        highestDigit = 0
        for i in range(index, len(batteryBankAsArrayOfInt)-digit+1):
            if (batteryBankAsArrayOfInt[i] > highestDigit):
                highestDigit = batteryBankAsArrayOfInt[i]
                index = i + 1
        joltage = joltage * 10 + highestDigit
    # print(f"Joltage: {joltage}")
    sum += joltage
print(f"Final sum: {sum}")


# def basic():
#     sum = 0
#     for batteryBank in batteryBanks:
#         bankAsArrayOfInt = list(map(int, batteryBank.strip()))

#         firstHighest = 0
#         secondHighest = 0
#         for i in range(0, len(bankAsArrayOfInt)-1):
#             if (bankAsArrayOfInt[i] > firstHighest):
#                 firstHighest = bankAsArrayOfInt[i]
#                 secondHighest = 0
#             if (bankAsArrayOfInt[i+1] > secondHighest):
#                 secondHighest = bankAsArrayOfInt[i+1]
#         print(
#             f"Product: {firstHighest}{secondHighest}")
#         sum += int(f"{firstHighest}{secondHighest}")

#         print(f"Final sum: {sum}")

# basic()
