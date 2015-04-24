redis = require 'redis'
durations = require 'durations'

key = 0
watch = durations.stopwatch().start()
runTimeMillis = 300000
jobCount = 10
counts = []
total = 0

job = (id, client=null) ->
  console.log "[#{id}] #{counts[id]} (#{total}) elapsed: #{watch}"
  
  if watch.duration().millis() > runTimeMillis
    console.log "client", id, "closed"
    client.quit()
  else if client
    key += 1
    client.set("000000000000000000000000000000000000000000000000000000000000000000" + key, "000000000000000000000000000000000000000000000000000000000000000000" + key, () ->
      total += 1
      counts[id] += 1
      job(id, client)
    )
  else
    job(id, redis.createClient())

counts.push(0) for i in [0 .. jobCount-1]
job(v) for v in [0 .. jobCount-1]

