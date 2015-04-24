validator = require 'valid-json'
durations = require 'durations'

validator.validate '.', quiet=false

console.log "Duration: ", durations.stopwatch().start().stop().format()

