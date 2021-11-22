from .abs_facade import AbsFacade
from twitter import *
from . import TOKEN, TOKEN_SECRET, CONSUMER_KEY, CONSUMER_SECRET

class TwitterFacade(AbsFacade):
    def get_twitter(self):
        t = Twitter(auth=OAuth(
                    TOKEN, TOKEN_SECRET, CONSUMER_KEY, CONSUMER_SECRET))

        timeline = t.statuses.home_timeline()
        return ((it['user']['name'], it['text']) for it in timeline )
