const bole = require('bole')
const log = bole('test')

bole.output({
  level: 'debug',
  stream: process.stdout
})

log.info('a thing happened')
log.debug('not sure if...')
log.warn('this could be problematic')
log.error('you are not going to like this')
