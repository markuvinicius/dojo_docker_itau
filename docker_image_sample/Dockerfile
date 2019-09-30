# Utiliza a imagem official do python 2.6 como base
FROM python:2.7-slim 
# Define o diretório base como /app (este commando tb cria este diretório)
WORKDIR /app 
# Copia o conteúdo do diretório atual do host para /app no container
COPY . /app 
# Instala as dependencias necessárias, declaradas no arquivo requirements.txt
RUN pip install --trusted-host pypi.python.org -r requirements.txt 
# Expoe a porta 80 do container para o host
EXPOSE 80 
# Define uma variável de ambiente 
ENV NAME World 
# Executa o arquivo app.py quando o container estiver disponível
CMD ["python", "app.py"]
