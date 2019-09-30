#!/usr/bin/env python
# -*- coding: utf-8 -*-

from .twitter_sync import TwitterSync
import boto3
import json
import io

class KinesisTwitterSync(TwitterSync):
    stream_name = None
    kinesis_client = None
    logger = None

    def __init__(self, stream_name=None, region=None, logger=None):
        self.stream_name = stream_name
        self.kinesis_client = boto3.client('kinesis', region_name=region)
        self.logger = logger

    def persist(self,document=None):
        self.logger.info('Enviando Documento')
        self.logger.debug(str(document))
        try:
            tweet_id = str(document['id'])
            put_response = self.kinesis_client.put_record( StreamName=self.stream_name, 
                                                            Data=document, 
                                                            PartitionKey=tweet_id)

            self.logger.info('Documento Enviado para Kinesis')
            self.logger.debug(str(put_response))

            return put_response
        except Exception as e:
            error_message = "Erro Enviando Documento para Kinesis: "
            if (e, 'message'):
                error_message = error_message + str(e.message)
            else:
                error_message = error_message + str(e)

            self.logger.error(error_message)
            return error_message

    def persist_stream(self, id=None, document=None):
        self.logger.info('Enviando Documento Stream')
        '''
        self.logger.debug("Type: " + document.EventType())
        self.logger.debug("Source:" + document.Source())
        self.logger.debug("EventTime: " + document.EventTime())
        self.logger.debug("ContentType: " + document.ContentType())
        self.logger.debug("Extensions: " + str(document.Extensions()))
        self.logger.debug("SchemURL: " + str(document.SchemaURL()))
        self.logger.debug("EventID: " + str(document.EventID()))
        self.logger.debug("CloudEventVersion: " + str(document.CloudEventVersion()))
        self.logger.debug("Data: " + str(document.Data()))
        '''        
        self.logger.debug("Enviando Documento Kinesis")
        put_response = self.kinesis_client.put_record( StreamName=self.stream_name, 
                                                        Data=document.Data(), 
                                                        PartitionKey=document.EventID())
        return put_response    

'''
        try:            
            
            self.logger.info('Documento Enviado para Kinesis')
            self.logger.debug(str(put_response))

            
        except Exception as e:
            error_message = "Erro Enviando Documento para Kinesis: "
            if (e, 'message'):
                error_message = error_message + str(e.message)
            else:
                error_message = error_message + str(e)

            self.logger.error(error_message)
            return error_message
'''