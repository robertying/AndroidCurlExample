#include <curl/curl.h>
#include "curl_a_website.h"

void curl_a_website(const char *url) {
    CURL *curl = curl_easy_init();

    curl_easy_setopt(curl, CURLOPT_URL, url);
#ifdef __ANDROID__
    // For https requests, you need to specify the ca-bundle path
    curl_easy_setopt(curl, CURLOPT_CAINFO, CA_BUNDLE_PATH);
#endif

    curl_easy_perform(curl);

    curl_easy_cleanup(curl);
}
