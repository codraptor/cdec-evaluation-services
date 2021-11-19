import csv
import requests

type_map = {}

with open('data/titles.csv', newline='') as csvfile:
    reader = csv.reader(csvfile, delimiter=' ', quotechar='|')
    count = 0
    for row in reader:
        if(count > 0):
            node = row[0].split(",")[0]
            URL = 'https://www.wikidata.org/wiki/Special:EntityData/' + node + '.json'
            response = requests.get(url = URL)
            json = response.json()
            entities = json['entities']
            if node in entities:
                node = entities[node]
                claims = node['claims']
                if 'P31' in claims:
                    property = claims['P31']
                    for elem in property:
                        id = elem['mainsnak']['datavalue']['value']['id']
                        if(id not in type_map):
                            type_map[id] = 0
                        type_map[id] += 1

        count += 1
        print(count)


name_map = {}

count += 1
for key in type_map:
    URL = 'https://www.wikidata.org/wiki/Special:EntityData/' + key + '.json'
    response = requests.get(url = URL)
    json = response.json()
    entities = json['entities']
    if node in entities:
        node = entities[node]
        name = node['labels']['en']['value']
        name_map[name] = type_map[key]

    count += 1
    print(count)

with open('data/distribution.csv', 'w', newline='') as csvfile:
    writer = csv.writer(csvfile, delimiter=' ', quotechar='|', quoting=csv.QUOTE_MINIMAL)
    for key in name_map:
        writer.writerow([key, name_map[key]])
    
