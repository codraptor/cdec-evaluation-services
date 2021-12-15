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

    # Print PostgreSQL details
    #print("PostgreSQL server information")
    #print(connection.get_dsn_parameters(), "\n")

    tsv_file = open("../xlec-data.item-postproc.tsv")
    read_tsv = csv.reader(tsv_file, delimiter="\t")

    count = 0

    for row in read_tsv:

        id = str(uuid.uuid4())
        node = row[0]
        lang = row[1]
        inlink_title = row[3]
        context = row[4]


        print(row)
        count += 1
        if count == 5:
            break

    # # Executing a SQL query
    # cursor.execute("SELECT version();")
    # # Fetch result
    # record = cursor.fetchone()
    # print("You are connected to - ", record, "\n")

except (Exception, Error) as error:
    print("Error while connecting to PostgreSQL", error)

finally:
    if (connection):
        cursor.close()
        connection.close()
        print("PostgreSQL connection is closed")