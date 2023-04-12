#!/usr/bin/env python3

import os

import psycopg2
import random
import time
import datetime as dt
from sqlalchemy.exc import IntegrityError

from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import NoSuchElementException, TimeoutException

import bs4
import logging
from datetime import date


logging.basicConfig(level=logging.INFO)


def get_max_plus_one_transaction_day():
    db_connection = None
    try:
        db_connection = psycopg2.connect(
            host="127.0.0.1",
            database="postgres",
            user="postgres",
            password="postgres",
            port="5432"
        )
        db_connection.autocommit = True
        cursor = db_connection.cursor()

        to_be_transaction_day_query = """select max(transaction_day) + 1 from rigz_king_trading_days ktd ;"""

        cursor.execute(to_be_transaction_day_query)

        to_be_transaction_day_query_result = cursor.fetchone()
        latest_transaction_day = to_be_transaction_day_query_result[0]
        cursor.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if db_connection is not None:
            print('Database connection closed.')

    return latest_transaction_day


def get_max_id():
    db_connection = None
    try:
        db_connection = psycopg2.connect(
            host="127.0.0.1",
            database="postgres",
            user="postgres",
            password="postgres",
            port="5432"
        )
        db_connection.autocommit = True
        cursor = db_connection.cursor()

        to_be_max_id_query = """select max(id) from rigz_queen_floorsheets qf ;"""

        cursor.execute(to_be_max_id_query)

        to_be_max_id_query_result = cursor.fetchone()
        max_id = to_be_max_id_query_result[0]
        cursor.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if db_connection is not None:
            print('Database connection closed.')

    return max_id


def bulk_insert_data(list_of_records):
    db_connection = None
    try:
        db_connection = psycopg2.connect(
            host="127.0.0.1",
            database="postgres",
            user="postgres",
            password="postgres",
            port="5432"
        )
        db_connection.autocommit = True
        cursor = db_connection.cursor()

        floorsheets_insert_query = """INSERT INTO rigz_queen_floorsheets
            (id, contract_no, stock_symbol, buyer_broker, seller_broker, quantity, rate, amount, transaction_date, transaction_day)
                VALUES(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"""

        cursor.executemany(floorsheets_insert_query, list_of_records)

        db_connection.commit
        db_connection.autocommit = True
        cursor.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if db_connection is not None:
            print('Database connection closed.')

    return


to_be_transaction_day_king = get_max_plus_one_transaction_day()

print('==============================')
print(to_be_transaction_day_king)
print('==============================')

to_be_max_id_queen = get_max_id()


print('==============================')
print(to_be_max_id_queen)
print('==============================')


class ElementHasCssClass(object):
    """An expectation for checking that an element has a particular css class.

    locator - used to find the element
    returns the WebElement once it has the particular css class
    """

    def __init__(self, locator, css_class):
        self.locator = locator
        self.css_class = css_class

    def __call__(self, driver):
        # Finding the referenced element
        element = driver.find_element(*self.locator)
        if self.css_class in element.get_attribute("class"):
            return element
        return False


headers = {
    'authority': 'www.nepalstock.com.np',
    'accept': 'application/json, text/plain, */*',
    'dnt': '1',
    'user-agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36',
    'sec-gpc': '1',
    'sec-fetch-site': 'same-origin',
    'sec-fetch-mode': 'cors',
    'sec-fetch-dest': 'empty',
    'referer': 'https://www.nepalstock.com/',
    'accept-language': 'en-US,en;q=0.9',
}

zone = os.environ['TZ'] = 'Asia/Kathmandu'
# time.tzset()
today = time.strftime('%Y') + '-' + time.strftime('%m') + \
    '-' + time.strftime('%d')


USER_AGENT = [
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) "
    "Chrome/85.0.4183.83 Safari/537.36 ",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.1 Safari/605.1.15",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.0 Safari/605.1.15",
    "Mozilla/5.0 (iPhone; CPU iPhone OS 14_7_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148",
    "Mozilla/5.0 (iPad; CPU OS 9_3_5 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13G36",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/605.1.15 (KHTML, like Gecko)",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36",
    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36",
    "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:88.0) Gecko/20100101 Firefox/88.0",
]

ua = random.choice(USER_AGENT)

options = webdriver.ChromeOptions()
options.headless = True
options.add_argument(f"user-agent={ua}")
options.add_argument("--ignore-certificate-errors")
options.add_argument("--allow-running-insecure-content")
options.add_argument("--disable-extensions")
options.add_argument("--proxy-server='direct://'")
options.add_argument("--proxy-bypass-list=*")
options.add_argument("--start-maximized")
options.add_argument("--disable-gpu")
options.add_argument("--disable-dev-shm-usage")
options.add_argument("--no-sandbox")

driver = webdriver.Chrome(options=options)
driver.get("https://www.nepalstock.com/floor-sheet")

wait = WebDriverWait(driver, 10)
as_of_div = wait.until(
    EC.presence_of_element_located((By.CLASS_NAME, "table__asofdate"))
)
as_of_div_span = as_of_div.find_element(by=By.TAG_NAME, value="span")
as_of = dt.datetime.strptime(
    as_of_div_span.text, "As of %b %d, %Y, %I:%M:%S %p")
# logging.info(f"As of {as_of}")

items_per_page = wait.until(
    EC.element_to_be_clickable(
        (By.XPATH,
         "(//div[@class='table__perpage']/select/option[@value='500'])")
    )
)
items_per_page.click()
filter = wait.until(
    EC.element_to_be_clickable(
        (By.XPATH, "(//button[@class='box__filter--search'])"))
)
filter.click()

wait.until(
    lambda driver: len(
        driver.find_elements(
            by=By.XPATH,
            value="//div[contains(@class, 'floorsheet')]/div[contains(@class, 'table-responsive')]//tbody//tr",
        )
    )
    > 10
)

time.sleep(5)
pagination_ul = wait.until(
    EC.presence_of_element_located((By.CLASS_NAME, "ngx-pagination"))
)
pagination_li_s = pagination_ul.find_elements(by=By.TAG_NAME, value="li")
pagination_last = (
    pagination_li_s[-2].find_elements(by=By.TAG_NAME, value="span")[-1].text
)
logging.info(f"Pagination last page: {pagination_last}")

tbl_headers = wait.until(
    EC.presence_of_all_elements_located(
        (
            By.XPATH,
            "//div[contains(@class, 'floorsheet')]/div[contains(@class, 'table-responsive')]//thead//th",
        )
    )
)
headers = {th.text.split()[0].lower(): idx for idx,
           th in enumerate(tbl_headers)}

success = True
page = 1
while page <= int(pagination_last):

    try:
        current_page_li = wait.until(
            EC.presence_of_element_located(
                (By.XPATH, "(//li[@class='current'])"))
        )
        wait.until(lambda _: str(page)
                   in current_page_li.text.split()[1:])
        logging.info(
            f"Current page is {current_page_li.text.split()[-1]} ::: ")
    except TimeoutException:
        logging.warning(f"Page {page} not current")
        page = page
        continue

    body = driver.page_source
    response = bs4.BeautifulSoup(markup=body, features="lxml")
    tbl_rows = response.table.tbody.find_all("tr")
    logging.info(f"Found {len(tbl_rows)} rows")

    try:

        listOfRecordsQueen = []

        for row in map(
            lambda tr: [td.text.strip() for td in tr.find_all("td")],
            response.table.tbody.find_all("tr"),
        ):

            floorsheets_record_to_entry_queen = (
                int(row[headers["sn"]]) + to_be_max_id_queen,
                row[headers["contract"]],
                row[headers["stock"]],
                row[headers["buyer"]].replace(",", ""),
                row[headers["seller"]].replace(",", ""),
                int(row[headers["quantity"]].replace(",", "")),
                float(row[headers["rate"]].replace(",", "")),
                float(row[headers["amount"]].replace(",", "")),
                date.today(),
                to_be_transaction_day_king)
            listOfRecordsQueen.append(floorsheets_record_to_entry_queen)

        # print(listOfRecordsQueen)
        bulk_insert_data(list_of_records=listOfRecordsQueen,
                         )

        logging.info(f"Page:{page} done")
    except IntegrityError as e:
        print(e)
        success = False
        logging.warning("Scrape failed")

    try:
        btn_next = wait.until(
            EC.presence_of_element_located(
                (By.CLASS_NAME, "pagination-next"))
        ).find_element(by=By.TAG_NAME, value="a")
        next_page_li = wait.until(
            EC.presence_of_element_located(
                (By.XPATH,
                 "//li[@class='current']/following-sibling::li")
            )
        )
        logging.info(f"Next page: {page + 1}")
        wait.until(lambda _: str(page + 1)
                   in next_page_li.text.split())
        btn_next.click()
        next_page_li = wait.until(
            EC.presence_of_element_located(
                (By.XPATH,
                 f"//li/span[contains(text(), '{page+1}')]/parent::li")
            )
        )
        wait.until(
            lambda _: "current" in next_page_li.get_attribute("class"))
    except NoSuchElementException as e:
        logging.info("next page button not found")
        break
    except TimeoutException as e:
        logging.info("next element click timed out")
        page = page
        continue

    page += 1

# engine.dispose()
driver.quit()
