# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
import mysql.connector

class ProductScraperPipeline:
    def __init__(self):
        self.create_connection()
        self.create_table()
    def create_connection(self):
        self.conn=mysql.connector.connect(
        host = 'localhost',
        user = 'root',
        password='lk7t947982',
        database='kolesakz')
        self.curr=self.conn.cursor()
    def create_table(self):
        self.curr.execute("""DROP TABLE IF EXISTS kolesa_tb""")
        self.curr.execute("""create table kolesa_tb( 
                car_link text,
                car_brand text,
                car_name text,
                car_year text,
                car_city text,
                car_gen text,
                car_body_type text,
                car_engine_capacity text,
                car_mileage text,
                car_transmission text,
                car_drive_unit text,
                car_wheel text,
                car_color text,
                car_passtamoj text, 
                car_price text)""")
    def process_item(self, item, spider):
        self.store_db(item)
        return item
    def store_db(self,item):
        self.curr.execute("""insert into kolesa_tb values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)""",
                (
                item['car_link'][0],
                item['car_brand'][0],
                item['car_name'][0],
                item['car_year'][0],
                item['car_city'][0],
                item['car_gen'][0],
                item['car_body_type'][0],
                item['car_engine_capacity'][0],
                item['car_mileage'][0],
                item['car_transmission'][0],
                item['car_drive_unit'][0],
                item['car_wheel'][0],
                item['car_color'][0],
                item['car_passtamoj'][0],
                item['car_price'][0]
        ))
        self.conn.commit()