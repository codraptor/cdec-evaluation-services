import csv
import psycopg2
import uuid

try:

    # Connect to an existing database
    connection = psycopg2.connect(user="postgres",
                                  password="password",
                                  host="localhost",
                                  port="5432",
                                  database="postgres")

    # Create a cursor to perform database operations
    cursor = connection.cursor()

    tsv_file = open("../xlec-data.item-postproc.tsv")
    read_tsv = csv.reader(tsv_file, delimiter="\t")

    count = 0

    for row in read_tsv:

        if(count > 0):

            id = str(uuid.uuid4())
            node = row[0]
            lang = row[1]
            
            inlink_title = row[3]
            context = row[4]

            cursor.execute("INSERT INTO LINKS VALUES(%s, %s, %s, %s, %s, null, null, null)", (id, node, lang, inlink_title, context))
            connection.commit() 

        print(count)
        count += 1

    tsv_file2 = open("../label_desc.tsv")
    read_tsv2 = csv.reader(tsv_file2, delimiter="\t")

    count = 0

    for row in read_tsv2:

        if(count > 0):

            id = str(uuid.uuid4())
            node = row[0]
            lang = row[1]
            title = row[2]
            description = row[3]

            cursor.execute("INSERT INTO wikidata VALUES(%s, %s, %s, %s)", (node, lang, title, description))
            connection.commit() 

        print(count)
        count += 1

except (Exception) as error:
    print("Error while connecting to PostgreSQL", error)

finally:
    if (connection):
        cursor.close()
        connection.close()
        print("PostgreSQL connection is closed")