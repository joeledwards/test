const c = require('@buzuli/color')
const crypto = require('crypto')

const colorPool = c.pool()

function hmac (description, key, data) {
  const hmac = crypto
    .createHmac('sha256', key)
    .update(data)
    .digest('hex')

  console.info(`${description} => ${colorPool(hmac)}`)
}

hmac('strings', 'key', 'data')
hmac('buffer-key', Buffer.from('key'), 'data')
hmac('buffer-data', 'key', Buffer.from('data'))
hmac('buffers-for-all', Buffer.from('key'), Buffer.from('data'))
hmac('slack-sig-string', Buffer.from('key'), `v0:12345:data`)
hmac('slack-sig-buffer', Buffer.from('key'), Buffer.concat([Buffer.from('v0:12345:'), Buffer.from('data')]))

