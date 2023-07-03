import json
import datetime

class Note:
    def __init__(self, id, title, body, created):
        self.id = id
        self.title = title
        self.body = body
        self.created = created
        self.last_updated = created

    def update(self, new_title, new_body):
        self.title = new_title
        self.body = new_body
        self.last_updated = datetime.datetime.now()



