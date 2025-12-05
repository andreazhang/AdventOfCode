import requests
import os

def getInputData(day, year=2025):
    url = f"https://adventofcode.com/{year}/day/{day}/input"
    cookies = dict(session=os.environ["AOC_SESSION"])
    response = requests.get(url, cookies=cookies)
    print(response)
    return response.text
