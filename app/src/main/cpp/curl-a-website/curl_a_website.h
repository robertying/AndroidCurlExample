#ifndef CURL_A_WEBSITE_H
#define CURL_A_WEBSITE_H

#ifdef __ANDROID__
extern char *CA_BUNDLE_PATH;
#endif

uint8_t curl_a_website(const char *url);
const char* get_curl_version();

#endif
