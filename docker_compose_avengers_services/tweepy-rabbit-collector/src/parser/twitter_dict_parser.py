#!/usr/bin/env python
# -*- coding: utf-8 -*-

from .event_parser import EventParser

class TwitterEventToDict(EventParser):

    logger = None

    def __init__(self,logger=None):
        self.logger = logger
    
    def parse_event(self, event=None):
        parsed_data = {}

        try:
            #parse basec tweet info
            parsed_data['id']       = str(event['id'])
            parsed_data['data']     = str(event['created_at'])

            #parse user data
            parsed_data['user'] = {}
            parsed_data['user']['id'] = str(event['user']['id']) if 'id' in event['user'] else None
            parsed_data['user']['name'] = str(event['user']['name']) if 'name' in event['user'] else None
            parsed_data['user']['screen_name'] = str(event['user']['screen_name']) if 'screen_name' in event['user'] else None
            parsed_data['user']['location'] = str(event['user']['location']) if 'location' in event['user'] else None
            parsed_data['user']['followers_count'] = str(event['user']['followers_count']) if 'followers_count' in event['user'] else None
            parsed_data['user']['friends_count'] = str(event['user']['friends_count']) if 'friends_count' in event['user'] else None
            parsed_data['user']['friends_count'] = str(event['user']['friends_count']) if 'friends_count' in event['user'] else None

            #parse tweet data            
            parsed_data['texto'] = str(event['extended_tweet']['full_text']) if 'extended_tweet' in event else str(event['text'])
            
            #parse retweet data
            if 'retweeted_status' in event:
                parsed_data['retweeted'] = True
                parsed_data['quote_count'] = str(event['retweeted_status']['quote_count'])
                parsed_data['reply_count'] = str(event['retweeted_status']['reply_count'])
                parsed_data['retweet_count'] = str(event['retweeted_status']['retweet_count'])
                parsed_data['favorite_count'] = str(event['retweeted_status']['favorite_count'])
            else:
                parsed_data['retweeted'] = False

            #parse quote data
            if 'quoted_status' in event:
                parsed_data['quoted'] = True
            else:
                parsed_data['quoted'] = False

            #parse geolocation data
            parsed_data['location'] = str(event['user']['location'])
            parsed_data['lang']     = str(event['lang'])
            parsed_data['geo']      = str(event['geo'])
            parsed_data['coordinates'] = str(event['coordinates'])
            parsed_data['place']    = str(event['place'])

            #parse entity data    
            parsed_data['entities'] = {}
            parsed_data['entities']['hashtags'] = str(event['entities']['hashtags']) if 'hashtags' in event['entities'] else None
            parsed_data['entities']['urls']     = str(event['entities']['urls']) if 'urls' in event['entities'] else None
            parsed_data['entities']['user_mentions'] = str(event['entities']['user_mentions']) if 'user_mentions' in event['entities'] else None
            parsed_data['entities']['media'] = str(event['entities']['media']) if 'media' in event['entities'] else None
        except Exception as e:
            error_message = 'Erro parseando tweet: '
            
            if hasattr(e , 'message'):
                error_message = error_message + e.message
            else:
                error_message = error_message + str(e)

            self.logger.error(error_message)
            exit(1)

        return parsed_data