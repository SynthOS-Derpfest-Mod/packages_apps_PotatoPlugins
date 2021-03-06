/*
 * Copyright (C) 2020 The Potato Open Sauce Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.synth.plugin.iota.common;

import android.annotation.ColorInt;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.Resources;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.BitmapShader;
import android.media.AudioManager;
import android.os.Message;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.potatoproject.plugin.volume.common.*;

import java.io.File;
import java.text.NumberFormat;
import java.util.Objects;

public class IotaUtils {

      public static final String TAG = "IotaUtils";

      public static int getVolumeAlignment(Context sysuiContext) {
          return Settings.System.getIntForUser(sysuiContext.getContentResolver(), Settings.System.VOLUME_PANEL_ALIGNMENT, 1, UserHandle.USER_CURRENT);
      }

      public static boolean getHideRinger(Context sysuiContext) {
          return Settings.System.getIntForUser(sysuiContext.getContentResolver(), Settings.System.SYNTHOS_HIDE_RINGER_VOLUMEPANEL, 1, UserHandle.USER_CURRENT) == 1;
      }

      public static boolean getHideExtended(Context sysuiContext) {
          return Settings.System.getIntForUser(sysuiContext.getContentResolver(), Settings.System.SYNTHOS_HIDE_EXTENDED_VOLUMEPANEL, 0, UserHandle.USER_CURRENT) == 1;
      }

      public static int getDimensionFromVariable(Context sysuiContext, String var) {
          final String variable  =  var;
          int intVariable = Settings.System.getIntForUser(sysuiContext.getContentResolver(),
                  variable, 20, UserHandle.USER_CURRENT);

          switch (intVariable) {
              case 0:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_0"));
              case 1:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_1"));
              case 2:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_2"));
              case 3:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_3"));
              case 4:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_4"));
              case 5:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_5"));
              case 6:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_6"));
              case 7:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_7"));
              case 8:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_8"));
              case 9:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_9"));
              case 10:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_10"));
              case 11:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_11"));
              case 12:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_12"));
              case 13:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_13"));
              case 14:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_14"));
              case 15:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_15"));
              case 16:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_16"));
              case 17:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_17"));
              case 18:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_18"));
              case 19:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_19"));
              case 20:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_20"));
              case 21:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_21"));
              case 22:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_22"));
              case 23:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_23"));
              case 24:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_24"));
              case 25:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_25"));
              case 26:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_26"));
              case 27:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_27"));
              case 28:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_28"));
              case 29:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_29"));
              case 30:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_30"));
              case 31:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_31"));
              case 32:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_32"));
              case 33:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_33"));
              case 34:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_34"));
              case 35:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_35"));
              case 36:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_36"));
              case 37:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_37"));
              case 38:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_38"));
              case 39:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_39"));
              case 40:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_40"));
              case 41:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_41"));
              case 42:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_42"));
              case 43:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_43"));
              case 44:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_44"));
              case 45:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_45"));
              case 46:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_46"));
              case 47:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_47"));
              case 48:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_48"));
              case 49:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_49"));
              case 50:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_50"));
              case 51:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_51"));
              case 52:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_52"));
              case 53:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_53"));
              case 54:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_54"));
              case 55:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_55"));
              case 56:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_56"));
              case 57:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_57"));
              case 58:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_58"));
              case 59:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_59"));
              case 60:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_60"));
              case 61:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_61"));
              case 62:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_62"));
              case 63:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_63"));
              case 64:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_64"));
              case 65:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_65"));
              case 66:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_66"));
              case 67:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_67"));
              case 68:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_68"));
              case 69:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_69"));
              case 70:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_70"));
              case 71:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_71"));
              case 72:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_72"));
              case 73:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_73"));
              case 74:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_74"));
              case 75:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_75"));
              case 76:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_76"));
              case 77:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_77"));
              case 78:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_78"));
              case 79:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_79"));
              case 80:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_80"));
              case 81:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_81"));
              case 82:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_82"));
              case 83:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_83"));
              case 84:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_84"));
              case 85:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_85"));
              case 86:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_86"));
              case 87:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_87"));
              case 88:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_88"));
              case 89:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_89"));
              case 90:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_90"));
              case 91:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_91"));
              case 92:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_92"));
              case 93:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_93"));
              case 94:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_94"));
              case 95:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_95"));
              case 96:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_96"));
              case 97:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_97"));
              case 98:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_98"));
              case 99:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_99"));
              case 100:
                  return (int) sysuiContext.getResources().getDimension(getDimension(sysuiContext, "volume_panel_padding_100"));
          }

          return 0;
      }

      public static int getDimension(Context context, String resName) {
          int resId = 0;
          try {
              Resources res = context.getPackageManager().getResourcesForApplication("com.android.systemui");
              resId = res.getIdentifier(resName, "dimen", "com.android.systemui");
          } catch (NameNotFoundException e) {
              e.printStackTrace();
          }
          return resId;
      }

      public static void setPaddingLocation(Context sysuiContext, boolean leftVolume, boolean isLandscape, boolean isHorizontal, WindowManager.LayoutParams window, ViewGroup dialog, ViewGroup mediaCard) {

          boolean mLeftVolumeRocker = leftVolume;

          try {
              WindowManager.LayoutParams lp = window;
              switch (getVolumeAlignment(sysuiContext)) {
                  case 0:
                      lp.gravity = (isHorizontal ? Gravity.CENTER_HORIZONTAL : (mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT)) | Gravity.TOP;
                      break;
                  case 1:
                  default:
                      lp.gravity = (isHorizontal ? Gravity.CENTER_HORIZONTAL : (mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT)) | Gravity.CENTER_VERTICAL;
                      break;
                  case 2:
                      lp.gravity = (isHorizontal ? Gravity.CENTER_HORIZONTAL : (mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT)) | Gravity.BOTTOM;
                      break;
              }
          } catch (Exception e) {
              Log.d(TAG, e.getMessage());
          }

          try {
              ViewGroup mDialogView = dialog;
              LinearLayout.LayoutParams dlp = (LinearLayout.LayoutParams) mDialogView.getLayoutParams();
              switch (getVolumeAlignment(sysuiContext)) {
                  case 0:
                      dlp.gravity = mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT | Gravity.TOP;
                      break;
                  case 1:
                  default:
                      dlp.gravity = mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT | Gravity.CENTER_VERTICAL;
                      break;
                  case 2:
                      dlp.gravity = mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT | Gravity.BOTTOM;
                      break;
              }
              dlp.setMargins(0,
                            (getDimensionFromVariable(sysuiContext, Settings.System.SYNTHOS_VOLUME_PANEL_PADDING_TOP) * (isLandscape ? 1 : 3)),
                            0,
                            (getDimensionFromVariable(sysuiContext, Settings.System.SYNTHOS_VOLUME_PANEL_PADDING_BOTTOM) * (isLandscape ? 1 : 3)));
              mDialogView.setLayoutParams(dlp);
          } catch (Exception e) {
              Log.d(TAG, e.getMessage());
          }

          try {
              ViewGroup mDialogView = dialog;
              FrameLayout.LayoutParams dlp = (FrameLayout.LayoutParams) mDialogView.getLayoutParams();
              switch (getVolumeAlignment(sysuiContext)) {
                  case 0:
                      dlp.gravity = mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT | Gravity.TOP;
                      break;
                  case 1:
                  default:
                      dlp.gravity = mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT | Gravity.CENTER_VERTICAL;
                      break;
                  case 2:
                      dlp.gravity = mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT | Gravity.BOTTOM;
                      break;
              }
              dlp.setMargins(0,
                            (getDimensionFromVariable(sysuiContext, Settings.System.SYNTHOS_VOLUME_PANEL_PADDING_TOP) * (isLandscape ? 1 : 3)),
                            0,
                            (getDimensionFromVariable(sysuiContext, Settings.System.SYNTHOS_VOLUME_PANEL_PADDING_BOTTOM) * (isLandscape ? 1 : 3)));
              mDialogView.setLayoutParams(dlp);
          } catch (Exception e) {
              Log.d(TAG, e.getMessage());
          }

          try {
              LinearLayout.LayoutParams dlp = (LinearLayout.LayoutParams) mediaCard.getLayoutParams();
              switch (getVolumeAlignment(sysuiContext)) {
                  case 0:
                      dlp.gravity = mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT | Gravity.TOP;
                      break;
                  case 1:
                  default:
                      dlp.gravity = mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT | Gravity.CENTER_VERTICAL;
                      break;
                  case 2:
                      dlp.gravity = mLeftVolumeRocker ? Gravity.LEFT : Gravity.RIGHT | Gravity.BOTTOM;
                      break;
              }
              mediaCard.setLayoutParams(dlp);
          } catch (Exception e) {
              Log.d(TAG, e.getMessage());
          }

      }

      public static void setBackgroud(Context context, View[] views, Drawable[] defaultDrawables, String[] defaultDrawablesNames) {
          int backgroundType = Settings.System.getIntForUser(context.getContentResolver(), Settings.System.SYNTHOS_VOLUME_PANEL_BACKGROUND_TYPE, 0, UserHandle.USER_CURRENT);
          switch (backgroundType) {
              case 0:
                  setDefaultBackground(context, views, defaultDrawables);
                  break;
              case 1:
                  setDefaultColorBackground(context, views, defaultDrawables, defaultDrawablesNames);
                  break;
              case 2:
                  setCustomColorBackground(context, views, defaultDrawables, defaultDrawablesNames);
                  break;
              case 3:
                  setImageBackground(context, views, defaultDrawables, defaultDrawablesNames);
                  break;
          }
      }

      public static void setDefaultBackground(Context context, View[] views, Drawable[] defaultDrawables) {
          for (int i = 0; i < views.length; i++) {
              views[i].setBackground(defaultDrawables[i]);
          }
      }

      public static void setDefaultColorBackground(Context context, View[] views, Drawable[] defaultDrawables, String[] defaultDrawablesNames) {
          float roundValue = (float) Settings.System.getIntForUser(context.getContentResolver(), Settings.System.VOLUME_DIALOG_ROUNDED_VALUE, 36, UserHandle.USER_CURRENT);
          boolean gradientStroke = Settings.System.getIntForUser(context.getContentResolver(), Settings.System.VOLUME_DIALOG_GRADIENT_STROKE, 1, UserHandle.USER_CURRENT) == 1;
          TypedValue tValue = new TypedValue();
          context.getTheme().resolveAttribute(android.R.attr.dialogCornerRadius, tValue, true);
          float roundSystem = (float) tValue.data;
          int colorDrawable;

          try {
              for (int i = 0; i < views.length; i++) {
                  if (defaultDrawablesNames[i].equals("rounded_bg_full")) {
                      TypedValue value = new TypedValue();
                      context.getTheme().resolveAttribute(android.R.attr.colorBackgroundFloating, value, true);
                      colorDrawable = value.data;
                      float[] round = {roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeDrawable(context, false, colorDrawable, round, gradientStroke));
                  } else if (defaultDrawablesNames[i].equals("volume_dialog_background")) {
                      colorDrawable = views[i].getContext().getResources().getColor(R.color.volume_dialog_background);
                      float[] round = {roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeDrawable(context, false, colorDrawable, round, gradientStroke));
                  } else if (defaultDrawablesNames[i].equals("volume_dialog_ringer_bcg")) {
                      colorDrawable = context.getResources().getColor(com.android.internal.R.color.gradient_start);
                      float[] round = {roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeDrawable(context, false, colorDrawable, round, gradientStroke));
                  } else {
                      TypedValue value = new TypedValue();
                      context.getTheme().resolveAttribute(android.R.attr.panelColorBackground, value, true);
                      colorDrawable = value.data;
                      float[] round = {0, 0, 0, 0, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeDrawable(context, false, colorDrawable, round, gradientStroke));
                  }
              }
          } catch (Exception e) {
              Log.d(TAG, e.getMessage());
          }
      }

      public static void setCustomColorBackground(Context context, View[] views, Drawable[] defaultDrawables, String[] defaultDrawablesNames) {
          float roundValue = (float) Settings.System.getIntForUser(context.getContentResolver(), Settings.System.VOLUME_DIALOG_ROUNDED_VALUE, 36, UserHandle.USER_CURRENT);
          boolean gradientStroke = Settings.System.getIntForUser(context.getContentResolver(), Settings.System.VOLUME_DIALOG_GRADIENT_STROKE, 1, UserHandle.USER_CURRENT) == 1;
          int color = Settings.System.getIntForUser(context.getContentResolver(), Settings.System.SYNTHOS_VOLUME_PANEL_BACKGROUND_COLOR, Color.WHITE, UserHandle.USER_CURRENT);
          TypedValue tValue = new TypedValue();
          context.getTheme().resolveAttribute(android.R.attr.dialogCornerRadius, tValue, true);
          float roundSystem = (float) tValue.data;

          try {
              for (int i = 0; i < views.length; i++) {
                  if (defaultDrawablesNames[i].equals("rounded_bg_full")) {
                      float[] round = {roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeDrawable(context, false, color, round, gradientStroke));
                  } else if (defaultDrawablesNames[i].equals("volume_dialog_background")) {
                      float[] round = {roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeDrawable(context, false, color, round, gradientStroke));
                  } else if (defaultDrawablesNames[i].equals("volume_dialog_ringer_bcg")) {
                      float[] round = {roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeDrawable(context, false, color, round, gradientStroke));
                  } else {
                      float[] round = {0, 0, 0, 0, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeDrawable(context, false, color, round, gradientStroke));
                  }
              }
          } catch (Exception e) {
              Log.d(TAG, e.getMessage());
          }
      }

      public static void setImageBackground(Context context, View[] views, Drawable[] defaultDrawables, String[] defaultDrawablesNames) {
          float roundValue = (float) Settings.System.getIntForUser(context.getContentResolver(), Settings.System.VOLUME_DIALOG_ROUNDED_VALUE, 36, UserHandle.USER_CURRENT);
          boolean gradientStroke = Settings.System.getIntForUser(context.getContentResolver(), Settings.System.VOLUME_DIALOG_GRADIENT_STROKE, 1, UserHandle.USER_CURRENT) == 1;
          int color = Settings.System.getIntForUser(context.getContentResolver(), Settings.System.SYNTHOS_VOLUME_PANEL_BACKGROUND_COLOR, Color.WHITE, UserHandle.USER_CURRENT);
          TypedValue tValue = new TypedValue();
          context.getTheme().resolveAttribute(android.R.attr.dialogCornerRadius, tValue, true);
          float roundSystem = (float) tValue.data;
          int colorDrawable;

          try {
              for (int i = 0; i < views.length; i++) {
                  if (defaultDrawablesNames[i].equals("rounded_bg_full")) {
                      float[] round = {roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeImage(context, views[i], color, round, gradientStroke));
                  } else if (defaultDrawablesNames[i].equals("volume_dialog_background")) {
                      float[] round = {roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeImage(context, views[i], color, round, gradientStroke));
                  } else if (defaultDrawablesNames[i].equals("volume_dialog_ringer_bcg")) {
                      colorDrawable = context.getResources().getColor(com.android.internal.R.color.gradient_start);
                      float[] round = {roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeDrawable(context, false, colorDrawable, round, gradientStroke));
                  } else {
                      float[] round = {0, 0, 0, 0, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(null);
                  }
              }
          } catch (Exception e) {
              Log.d(TAG, e.getMessage());
          }
      }

      public static void setRoundedBackground(Context context, View[] views, Drawable[] defaultDrawables, String[] defaultDrawablesNames) {
          float roundValue = (float) Settings.System.getIntForUser(context.getContentResolver(), Settings.System.VOLUME_DIALOG_ROUNDED_VALUE, 36, UserHandle.USER_CURRENT);
          boolean gradientStroke = Settings.System.getIntForUser(context.getContentResolver(), Settings.System.VOLUME_DIALOG_GRADIENT_STROKE, 1, UserHandle.USER_CURRENT) == 1;
          boolean roundDefault = Settings.System.getIntForUser(context.getContentResolver(), Settings.System.VOLUME_DIALOG_ROUNDED_SYSTEM, 1, UserHandle.USER_CURRENT) == 1;
          int backgroundType = Settings.System.getIntForUser(context.getContentResolver(), Settings.System.SYNTHOS_VOLUME_PANEL_BACKGROUND_TYPE, 0, UserHandle.USER_CURRENT);
          int color = Settings.System.getIntForUser(context.getContentResolver(), Settings.System.SYNTHOS_VOLUME_PANEL_BACKGROUND_COLOR, Color.WHITE, UserHandle.USER_CURRENT);
          TypedValue tValue = new TypedValue();
          context.getTheme().resolveAttribute(android.R.attr.dialogCornerRadius, tValue, true);
          float roundSystem = (float) tValue.data;
          float lastRound = roundValue;
          int colorDrawable;

          try {
              for (int i = 0; i < views.length; i++) {
                  if (defaultDrawablesNames[i].equals("rounded_bg_full")) {
                      TypedValue value = new TypedValue();
                      context.getTheme().resolveAttribute(android.R.attr.colorBackgroundFloating, value, true);
                      colorDrawable = backgroundType == 1 ? value.data : color;
                      float[] round = {lastRound, lastRound, lastRound, lastRound, lastRound, lastRound, lastRound, lastRound};
                      views[i].setBackground(createGradientStrokeDrawable(context, (backgroundType == 3), colorDrawable, round, gradientStroke));
                  } else if (defaultDrawablesNames[i].equals("volume_dialog_background")) {
                      colorDrawable = backgroundType == 1 ? views[i].getContext().getResources().getColor(R.color.accent_tint_color_selector) : color;
                      float[] round = {roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeDrawable(context, (backgroundType == 3), colorDrawable, round, gradientStroke));
                  } else if (defaultDrawablesNames[i].equals("volume_dialog_ringer_bcg")) {
                      TypedValue value = new TypedValue();
                      context.getTheme().resolveAttribute(android.R.attr.colorAccent, value, true);
                      colorDrawable = backgroundType == 1 ? context.getResources().getColor(com.android.internal.R.color.gradient_start) : color;
                      float[] round = {roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue, roundValue};
                      views[i].setBackground(createGradientStrokeDrawable(context, (backgroundType == 3), colorDrawable, round, gradientStroke));
                  } else {
                      TypedValue value = new TypedValue();
                      context.getTheme().resolveAttribute(android.R.attr.panelColorBackground, value, true);
                      colorDrawable = backgroundType == 1 ? value.data : color;
                      float[] round = {0, 0, 0, 0, lastRound, lastRound, lastRound, lastRound};
                      views[i].setBackground(createGradientStrokeDrawable(context, (backgroundType == 3), colorDrawable, round, gradientStroke));
                  }
              }
          } catch (Exception e) {
              Log.d(TAG, e.getMessage());
          }
      }

      public static Drawable createGradientStrokeDrawable(Context context, boolean image, int color, float[] round, boolean stroke) {
          if (stroke) {
              return createGradientStrokeDrawable(context, image, color, round);
          } else {
              return createRoundShapeDrawable(context, image, color, round);
          }
      }

      public static Drawable createGradientStrokeImage(Context context, View view, int color, float[] round, boolean stroke) {
          if (stroke) {
              return createGradientStrokeDrawable(context, view, color, round);
          } else {
              return createRoundShapeDrawable(context, view, color, round);
          }
      }

      public static LayerDrawable createGradientStrokeDrawable(Context context, boolean image, int color, float[] round) {
          GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                                                                  new int[] {context.getResources().getColor(com.android.internal.R.color.gradient_start)
                                                                            ,context.getResources().getColor(com.android.internal.R.color.gradient_end)});
          gradientDrawable.setCornerRadii(round);

          LayerDrawable layerDrawable = new LayerDrawable(new Drawable[] {gradientDrawable, createRoundShapeDrawable(context, image, color, round)});
          layerDrawable.setLayerInset(1, 2, 2, 2, 2);
          return layerDrawable;
      }

      public static LayerDrawable createGradientStrokeDrawable(Context context, View view, int color, float[] round) {
          GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                                                                  new int[] {context.getResources().getColor(com.android.internal.R.color.gradient_start)
                                                                            ,context.getResources().getColor(com.android.internal.R.color.gradient_end)});
          gradientDrawable.setCornerRadii(round);

          Drawable shapeDrawable = createRoundShapeDrawable(context, view, color, round);
          LayerDrawable layerDrawable = new LayerDrawable(new Drawable[] {gradientDrawable, shapeDrawable});
          layerDrawable.setLayerInset(1, 2, 2, 2, 2);
          return layerDrawable;
      }

      public static ShapeDrawable createRoundShapeDrawable(Context context, boolean image, int color, float[] round) {
          RoundRectShape rrS = new RoundRectShape(round, null, null);
          ShapeDrawable shapeDrawable = new ShapeDrawable(rrS);
          shapeDrawable.setColorFilter(new PorterDuffColorFilter(color, Mode.SRC_ATOP));
          return shapeDrawable;
      }

      private static class CustomShapeDrawable extends ShapeDrawable {

          private Context mContext;
          private float mRound;
          private int mColor;
          private boolean draw;
          private float width;
          private float height;
          private Bitmap bitmap;
          private Bitmap scaledBitmap;
          private BitmapShader shader;

          public CustomShapeDrawable(Context context, Shape shape, float round, int color) {
              super(shape);
              mContext = context;
              mRound = round;
              mColor = color;
              width = 0f;
              height = 0f;
          }

          @Override
          protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
              draw = shape.getWidth() != width || shape.getHeight() != height;
              try {
                  if (draw) {
                      bitmap = getCustomImageFromString(mContext, "synthos_volume_panel_background_image").getBitmap();
                      scaledBitmap = scaleCenterCrop(bitmap, (int) shape.getWidth(), (int) shape.getHeight());
                      shader = new BitmapShader(scaledBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                      draw = false;
                      width = shape.getWidth();
                      height = shape.getHeight();
                  }
                  if (bitmap != null) {
                      paint.setAntiAlias(true);
                      paint.setShader(shader);
                  }
              } catch (Exception e) {
                  Log.d(TAG, e.getMessage());
              }

              super.onDraw(shape, canvas, paint);
          }

      }

      public static Drawable createRoundShapeDrawable(Context context, View view, int color, float[] round) {
          RoundRectShape rrS = new RoundRectShape(round, null, null);
          CustomShapeDrawable shapeDrawable = new CustomShapeDrawable(context, rrS, round[7], color);
          return shapeDrawable;
      }

      public static BitmapDrawable getCustomImageFromString(Context sysuiContext, String fileName) {
          BitmapDrawable mImage = null;
          File file = new File(sysuiContext.getFilesDir(), fileName);
          if (file.exists()) {
              final Bitmap image = BitmapFactory.decodeFile(file.getAbsolutePath());
              mImage = new BitmapDrawable(sysuiContext.getResources(), resizeMaxDeviceSize(sysuiContext, image));
          }
          return mImage;
      }

      public static Bitmap resizeMaxDeviceSize(Context context, Bitmap image) {
          Bitmap imageToBitmap;
          DisplayMetrics metrics = new DisplayMetrics();
          WindowManager wm = context.getSystemService(WindowManager.class);
          wm.getDefaultDisplay().getRealMetrics(metrics);
          int maxHeight = metrics.heightPixels;
          int maxWidth = metrics.widthPixels;
          try {
              imageToBitmap = RGB565toARGB888(image);
              if (maxHeight > 0 && maxWidth > 0) {
                  int width = imageToBitmap.getWidth();
                  int height = imageToBitmap.getHeight();
                  float ratioBitmap = (float) width / (float) height;
                  float ratioMax = (float) maxWidth / (float) maxHeight;

                  int finalWidth = maxWidth;
                  int finalHeight = maxHeight;
                  if (ratioMax > ratioBitmap) {
                      finalWidth = (int) ((float)maxHeight * ratioBitmap);
                  } else {
                      finalHeight = (int) ((float)maxWidth / ratioBitmap);
                  }
                  imageToBitmap = Bitmap.createScaledBitmap(imageToBitmap, finalWidth, finalHeight, true);
                  return imageToBitmap;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
          return image;
      }

      private static Bitmap RGB565toARGB888(Bitmap img) throws Exception {
          int numPixels = img.getWidth() * img.getHeight();
          int[] pixels = new int[numPixels];

          //Get JPEG pixels.  Each int is the color values for one pixel.
          img.getPixels(pixels, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());

          //Create a Bitmap of the appropriate format.
          Bitmap result = Bitmap.createBitmap(img.getWidth(), img.getHeight(), Bitmap.Config.ARGB_8888);

          //Set RGB pixels.
          result.setPixels(pixels, 0, result.getWidth(), 0, 0, result.getWidth(), result.getHeight());
          return result;
      }

      public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int round, int width, int height, int color) {
        if (bitmap == null) {
            return null;
        }

        int zeroWidth = (width <= 0) ? bitmap.getWidth() : width;
        int zeroHeight = (height <= 0) ? bitmap.getHeight() : height;
        int rectWidth = (bitmap.getWidth() <= width) ? zeroWidth : bitmap.getWidth();
        int rectHeight = (bitmap.getWidth() <= height) ? zeroHeight : bitmap.getWidth();

        Bitmap output = Bitmap.createBitmap(zeroWidth, zeroHeight,
                Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, rectWidth, rectHeight);
        final Rect roundRect = new Rect(0, 0, zeroWidth, zeroHeight);
        final RectF rectF = new RectF(roundRect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, round, round, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
      }

      public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int round, int width, int height) {
          return getRoundedCornerBitmap(bitmap, round, width, height, 0xff424242);
      }

      public static Bitmap scaleCenterCrop(Bitmap source, int newWidth, int newHeight) {
        int sourceWidth = source.getWidth();
        int sourceHeight = source.getHeight();

        // Compute the scaling factors to fit the new height and width, respectively.
        // To cover the final image, the final scaling will be the bigger
        // of these two.
        float xScale = (float) newWidth / sourceWidth;
        float yScale = (float) newHeight / sourceHeight;
        float scale = Math.max(xScale, yScale);

        // Now get the size of the source bitmap when scaled
        float scaledWidth = scale * sourceWidth;
        float scaledHeight = scale * sourceHeight;

        // Let's find out the upper left coordinates if the scaled bitmap
        // should be centered in the new size give by the parameters
        float left = (newWidth - scaledWidth) / 2;
        float top = (newHeight - scaledHeight) / 2;

        // The target rectangle for the new, scaled version of the source bitmap will now
        // be
        RectF targetRect = new RectF(left, top, left + scaledWidth, top + scaledHeight);

        // Finally, we create a new bitmap of the specified size and draw our new,
        // scaled bitmap onto it.
        Bitmap dest = Bitmap.createBitmap(newWidth, newHeight, source.getConfig());
        Canvas canvas = new Canvas(dest);
        canvas.drawBitmap(source, null, targetRect, null);

        return dest;
      }

      public static void hideThings(Context sysuiContext, View mRinger) {
          hideThings(sysuiContext, mRinger, null, null);
      }

      public static void hideThings(Context sysuiContext, View mRinger, View mExpandRowsView) {
          hideThings(sysuiContext, mRinger, mExpandRowsView, null);
      }

      public static void hideThings(Context sysuiContext, View mRinger, View mExpandRowsView, View mBackgroundThings) {
          if (mRinger != null && getHideRinger(sysuiContext)) {
              mRinger.setVisibility(View.GONE);
          } else if (mRinger != null && !getHideRinger(sysuiContext)) {
              mRinger.setVisibility(View.VISIBLE);
          }
          if (mExpandRowsView != null && getHideExtended(sysuiContext)) {
              mExpandRowsView.setVisibility(View.GONE);
          } else if (mExpandRowsView != null && !getHideExtended(sysuiContext)) {
              mExpandRowsView.setVisibility(View.VISIBLE);
          }
          if (mBackgroundThings != null && getHideRinger(sysuiContext) && getHideExtended(sysuiContext)) {
              mBackgroundThings.setVisibility(View.GONE);
          } else if (mBackgroundThings != null && (!getHideRinger(sysuiContext) || !getHideExtended(sysuiContext)))  {
              mBackgroundThings.setVisibility(View.VISIBLE);
          }
      }
}
