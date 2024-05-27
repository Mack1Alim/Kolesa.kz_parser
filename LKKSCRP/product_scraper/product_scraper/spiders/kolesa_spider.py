import scrapy
from ..items import ProductScraperItem

class KolesaSpider(scrapy.Spider):
    name="kolesa"
    start_urls=['https://kolesa.kz/cars/']
    page_number=2
    
    def parse(self,response):
        items = ProductScraperItem()
        carlist=response.css('div.a-list')
        car_links = carlist.css('.a-card__link::attr(href)')
        for link in car_links:
            yield response.follow(link,callback = self.parse2)
        next_page='https://kolesa.kz/cars/?page='+ str(KolesaSpider.page_number)
        if KolesaSpider.page_number <= 10:
            KolesaSpider.page_number+=1
            yield response.follow(next_page,callback = self.parse)

    def parse2(self,response):
        items = ProductScraperItem()
        car_link=response.css('link::attr(href)').extract()
        car_brand=response.css(".offer__title span:nth-child(1)::text").extract()
        car_name=response.css('.offer__title span:nth-child(2)::text').extract()
        car_year=response.css('.year::text').extract()
        car_price=response.css('div.offer__price::text').extract()
        car_city=response.css('dl:nth-child(1) .value::text').extract()
        car_gen=response.css('dl:nth-child(2) .value::text').extract()
        car_body_type=response.css('dl:nth-child(3) .value::text').extract()
        car_engine_capacity=response.css('dl:nth-child(4) .value::text').extract()
        car_mileage=response.css('dl:nth-child(5) .value::text').extract()
        car_transmission=response.css('dl:nth-child(6) .value::text').extract()
        car_drive_unit=response.css('dl:nth-child(7) .value::text').extract()
        car_wheel=response.css('dl:nth-child(8) .value::text').extract()
        car_color=response.css('dl:nth-child(9) .value::text').extract()
        car_passtamoj=response.css('dl:nth-child(10) .value::text').extract()
        items['car_link']=car_link
        items['car_brand']=car_brand
        items['car_name']=car_name
        items['car_year']=car_year
        items['car_city']=car_city
        items['car_gen']=car_gen
        items['car_body_type']=car_body_type
        items['car_engine_capacity']=car_engine_capacity
        items['car_mileage']=car_mileage
        items['car_transmission']=car_transmission
        items['car_drive_unit']=car_drive_unit
        items['car_wheel']=car_wheel
        items['car_color']=car_color
        #items['car_color'] = [items.replace('/n', '') for items in car_color]
        items['car_passtamoj']=car_passtamoj
        items['car_price']=car_price
        yield items

                                    