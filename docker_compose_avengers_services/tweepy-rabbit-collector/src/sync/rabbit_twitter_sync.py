#!/usr/bin/env python
# -*- coding: utf-8 -*-

from .twitter_sync import TwitterSync
import pika
import json
import uuid

class RabbitTwitterSync(TwitterSync):
    
    connection = None
    channel = None
    queue = None
    logger = None
    properties = None

    def __init__(self, host=None, queue=None, logger=None):        
        logger.debug(host)
        logger.debug(queue)
        parameters = ( pika.ConnectionParameters(host=host,
                                                    connection_attempts=20, 
                                                    retry_delay=10))

        self.properties = pika.spec.BasicProperties(
            app_id = "twitter-collector:" + str(uuid.uuid1()) ,
            content_type='application/json',
            content_encoding='utf-8'            
        )

        self.connection  = pika.BlockingConnection(parameters)
        self.channel = self.connection.channel()
        self.queue = queue
        self.channel.queue_declare(queue=self.queue)
        self.logger = logger

    def persist(self,document=None):
        self.logger.info('Enviando Documento para fila: ' + self.queue)
        self.logger.debug(str(document))
        try:
            self.channel.basic_publish(exchange='', 
                                        routing_key=self.queue,
                                        body=json.dumps(document),
                                        properties = self.properties)
            
            self.logger.info('Documento Enviado para Fila')            

            return
        except Exception as e:
            error_message = "Erro Enviando Documento para fila: " + self.queue 
            if (e, 'message'):
                error_message = error_message + str(e.message)
            else:
                error_message = error_message + str(e)

            self.logger.error(error_message)
            return error_message