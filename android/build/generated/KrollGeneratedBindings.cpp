/* C++ code produced by gperf version 3.0.4 */
/* Command-line: gperf -L C++ -E -t /tmp/hugo/ffmpeg-android-wrapper-generated/KrollGeneratedBindings.gperf  */
/* Computed positions: -k'' */

#line 3 "/tmp/hugo/ffmpeg-android-wrapper-generated/KrollGeneratedBindings.gperf"


#include <string.h>
#include <v8.h>
#include <KrollBindings.h>

#include "com.badoque.ffmpeg.android.FfmpegAndroidWrapperModule.h"


#line 13 "/tmp/hugo/ffmpeg-android-wrapper-generated/KrollGeneratedBindings.gperf"
struct titanium::bindings::BindEntry;
/* maximum key range = 1, duplicates = 0 */

class FfmpegAndroidWrapperBindings
{
private:
  static inline unsigned int hash (const char *str, unsigned int len);
public:
  static struct titanium::bindings::BindEntry *lookupGeneratedInit (const char *str, unsigned int len);
};

inline /*ARGSUSED*/
unsigned int
FfmpegAndroidWrapperBindings::hash (register const char *str, register unsigned int len)
{
  return 0;
}

struct titanium::bindings::BindEntry *
FfmpegAndroidWrapperBindings::lookupGeneratedInit (register const char *str, register unsigned int len)
{
  enum
    {
      TOTAL_KEYWORDS = 1,
      MIN_WORD_LENGTH = 53,
      MAX_WORD_LENGTH = 53,
      MIN_HASH_VALUE = 0,
      MAX_HASH_VALUE = 0
    };

  static struct titanium::bindings::BindEntry wordlist[] =
    {
#line 15 "/tmp/hugo/ffmpeg-android-wrapper-generated/KrollGeneratedBindings.gperf"
      {"com.badoque.ffmpeg.android.FfmpegAndroidWrapperModule", ::com::badoque::ffmpeg::android::FfmpegAndroidWrapperModule::bindProxy, ::com::badoque::ffmpeg::android::FfmpegAndroidWrapperModule::dispose}
    };

  if (len <= MAX_WORD_LENGTH && len >= MIN_WORD_LENGTH)
    {
      register int key = hash (str, len);

      if (key <= MAX_HASH_VALUE && key >= 0)
        {
          register const char *s = wordlist[key].name;

          if (*str == *s && !strcmp (str + 1, s + 1))
            return &wordlist[key];
        }
    }
  return 0;
}
#line 16 "/tmp/hugo/ffmpeg-android-wrapper-generated/KrollGeneratedBindings.gperf"

