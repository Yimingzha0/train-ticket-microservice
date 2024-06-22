#Test script for the fine-grained train-ticketing microservice system
from locust import HttpUser, TaskSet, task, between, constant_pacing

import random
class AdminUserServiceTask(TaskSet):

        @task
        def get_request(self):
            self.client.get("/api/v1/userservice/users")

class ConsignPriceServiceTask(TaskSet):

            @task
            def post_request(self):
                #randon generate beyondPrice, initialPrice
                initialPrice = random.randint(1, 10)
                beyondPrice = random.randint(1, 10)
                price = {
                          "beyondPrice": 1,
                          "id": "a1a942e5-032f-4b37-acb1-fcb8bd1657c2",
                          "index": 0,
                          "initialPrice": 2,
                          "initialWeight": 1,
                          "withinPrice": 2
                        }
                self.client.post("/api/v1/consignpriceservice/consignprice", json=price)

# Admin User Service Test
class AdminUserService(HttpUser):
    tasks = [AdminUserServiceTask]
    wait_time = constant_pacing(1)
    host = "http://localhost:12346"

# Consign Price Service Test
class ConsignPriceService(HttpUser):
    tasks = [ConsignPriceServiceTask]
    wait_time = constant_pacing(1)
    host = "http://localhost:15679"
