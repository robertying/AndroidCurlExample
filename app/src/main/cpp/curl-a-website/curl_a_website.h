#ifndef CURL_A_WEBSITE_H
#define CURL_A_WEBSITE_H

#ifdef __ANDROID__
extern char *CA_BUNDLE_PATH;
#endif

void curl_a_website(const char *url);

#endif
