# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy
import re
class ProductScraperItem(scrapy.Item):

    car_link=scrapy.Field()
    car_brand=scrapy.Field()  
    car_name=scrapy.Field()
    car_year=scrapy.Field()
    car_city=scrapy.Field()
    car_gen=scrapy.Field()
    car_body_type=scrapy.Field()
    car_engine_capacity=scrapy.Field()
    car_mileage=scrapy.Field()
    car_transmission=scrapy.Field()
    car_drive_unit=scrapy.Field()
    car_wheel=scrapy.Field()
    car_color=scrapy.Field()
    car_passtamoj=scrapy.Field()
    car_price=scrapy.Field()
