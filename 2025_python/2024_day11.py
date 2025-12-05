from utils import *
import time
import functools

input = "0 1 10 99 999"
input = "125 17"
# input = "0"
input = getInputData(11, 2024)

digits = list(map(int, input.strip().split()))
    
print(digits)

@functools.cache
def blink(digit, counter):
    counter += 1
    if counter > 75:
        return 1

    start_time = time.time()

        # print(">", i, digit, input)
    if digit == 0:
        return blink(1, counter)
    elif len(str(digit)) % 2 == 0:
        digitString = str(digit)
        return blink(int(digitString[:int(len(digitString)/2)]), counter) +  blink(int(digitString[int(len(digitString)/2):]), counter)
    else:
        return blink(digit*2024, counter)
    
    # print(newInput)
    print (f"#{counter}: {len(newInput)} stones - {(time.time() - start_time)}s")

    return blink(newInput, counter)

def blonk(digits):
    total = 0
    for digit in digits:
        total += blink(digit, 0)
    return total

output = blonk(digits)
print(f"Final # of stones: {output}")
