cmake_minimum_required(VERSION 3.5)

# Project name can only contains upper and lower case letters, numbers,
# the underscore character (_), dot(.), plus(+) and minus(-).
project(world C)


set(CMAKE_MODULES_DIR "${CMAKE_CURRENT_SOURCE_DIR}/builds/cmake")
list(APPEND CMAKE_MODULE_PATH ${CMAKE_MODULES_DIR})
include(IdentifyOS)

# agent and external dependencies (if any)
add_executable(${PROJECT_NAME} src/main.c)
# set executable name
set_target_properties(${PROJECT_NAME} PROPERTIES OUTPUT_NAME "world")

# Override default release flags to not define NDEBUG, which CMake sets by default for Release builds
# NB: The NDEBUG flag compile out all assert() calls, skipping whatever was done in the assert call (function call, computation, etc.)
# It changes the compiled code from the source code and we don't want that.
if (NOT CMAKE_BUILD_TYPE STREQUAL "Debug")
   # Enable assertions in release mode
   message(STATUS "Enable C asserts in release mode (instead of noop)")
   if (MSVC)
       string(REPLACE "/D NDEBUG" "" CMAKE_CXX_FLAGS_RELEASE ${CMAKE_CXX_FLAGS_RELEASE})
       string(REPLACE "/D NDEBUG" "" CMAKE_CXX_FLAGS_RELWITHDEBINFO ${CMAKE_CXX_FLAGS_RELWITHDEBINFO})
       string(REPLACE "/D NDEBUG" "" CMAKE_CXX_FLAGS_MINSIZEREL ${CMAKE_CXX_FLAGS_MINSIZEREL})

       string(REPLACE "/DNDEBUG" "" CMAKE_CXX_FLAGS_RELEASE ${CMAKE_CXX_FLAGS_RELEASE})
       string(REPLACE "/DNDEBUG" "" CMAKE_CXX_FLAGS_RELWITHDEBINFO ${CMAKE_CXX_FLAGS_RELWITHDEBINFO})
       string(REPLACE "/DNDEBUG" "" CMAKE_CXX_FLAGS_MINSIZEREL ${CMAKE_CXX_FLAGS_MINSIZEREL})

       string(REPLACE "/D NDEBUG" "" CMAKE_C_FLAGS_RELEASE ${CMAKE_C_FLAGS_RELEASE})
       string(REPLACE "/D NDEBUG" "" CMAKE_C_FLAGS_RELWITHDEBINFO ${CMAKE_C_FLAGS_RELWITHDEBINFO})
       string(REPLACE "/D NDEBUG" "" CMAKE_C_FLAGS_MINSIZEREL ${CMAKE_C_FLAGS_MINSIZEREL})

       string(REPLACE "/DNDEBUG" "" CMAKE_C_FLAGS_RELEASE ${CMAKE_C_FLAGS_RELEASE})
       string(REPLACE "/DNDEBUG" "" CMAKE_C_FLAGS_RELWITHDEBINFO ${CMAKE_C_FLAGS_RELWITHDEBINFO})
       string(REPLACE "/DNDEBUG" "" CMAKE_C_FLAGS_MINSIZEREL ${CMAKE_C_FLAGS_MINSIZEREL})
   else()
       string(REPLACE "-DNDEBUG" "" CMAKE_CXX_FLAGS_RELEASE "${CMAKE_CXX_FLAGS_RELEASE}")
       string(REPLACE "-DNDEBUG" "" CMAKE_CXX_FLAGS_RELWITHDEBINFO "${CMAKE_CXX_FLAGS_RELWITHDEBINFO}")
       string(REPLACE "-DNDEBUG" "" CMAKE_CXX_FLAGS_MINSIZEREL "${CMAKE_CXX_FLAGS_MINSIZEREL}")

       string(REPLACE "-DNDEBUG" "" CMAKE_C_FLAGS_RELEASE "${CMAKE_C_FLAGS_RELEASE}")
       string(REPLACE "-DNDEBUG" "" CMAKE_C_FLAGS_RELWITHDEBINFO "${CMAKE_C_FLAGS_RELWITHDEBINFO}")
       string(REPLACE "-DNDEBUG" "" CMAKE_C_FLAGS_MINSIZEREL "${CMAKE_C_FLAGS_MINSIZEREL}")
   endif()
endif()


option(WITH_ASAN "Activate Clang Address Sanitizer" OFF)
if (WITH_ASAN)
  message (STATUS "Clang Address Sanitizer activated by passing -DWITH_ASAN=ON")
  target_compile_options(${PROJECT_NAME} PRIVATE -fsanitize=address)
  target_link_libraries(${PROJECT_NAME} PRIVATE -fsanitize=address)
endif(WITH_ASAN)

if(UNIX AND NOT APPLE)
    #FIXME Is the condition necessary even when using C_STANDARD property?
    set_target_properties(${PROJECT_NAME}
      PROPERTIES
        C_STANDARD 99
    )
endif()

target_include_directories(${PROJECT_NAME} PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/src) # local headers

if (WIN32)
    target_include_directories(${PROJECT_NAME} PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/packaging/windows)
endif (WIN32)

find_package (sodium)
find_package (ZeroMQ 4.3 REQUIRED)
if (ZeroMQ_FOUND)
    target_link_libraries (${PROJECT_NAME} PRIVATE libzmq)
else (ZeroMQ_FOUND)
    message(FATAL_ERROR "ZeroMQ - Dependency not found")
endif (ZeroMQ_FOUND)

find_package (czmq 4.2 REQUIRED)
if (czmq_FOUND)
    target_link_libraries (${PROJECT_NAME} PRIVATE czmq)
else (czmq_FOUND)
    message(FATAL_ERROR "czmq - Dependency not found")
endif (czmq_FOUND)

find_package (zyre 2.0 REQUIRED)
if (zyre_FOUND)
  target_link_libraries (${PROJECT_NAME} PRIVATE zyre)
else (zyre_FOUND)
  message(FATAL_ERROR "zyre - Dependency not found")
endif (zyre_FOUND)

find_package (ingescape 4 REQUIRED)
if (ingescape_FOUND)
    target_link_libraries (${PROJECT_NAME} PRIVATE ingescape)
else (ingescape_FOUND)
    message(FATAL_ERROR "ingescape - Dependency not found")
endif (ingescape_FOUND)

set_property( DIRECTORY PROPERTY VS_STARTUP_PROJECT "${PROJECT_NAME}" )

install (TARGETS ${PROJECT_NAME} RUNTIME DESTINATION bin COMPONENT agent)

########################################################################
# installer
########################################################################
# Package installer for release build only
if (CMAKE_BUILD_TYPE STREQUAL "Release")
  set(CPACK_PACKAGE_NAME "${PROJECT_NAME}")
  set(CPACK_PACKAGE_DESCRIPTION_SUMMARY "${OUTPUT_NAME} ingescape agent")
  set(CPACK_PACKAGE_DESCRIPTION "${OUTPUT_NAME} ingescape agent")
  set(CPACK_PACKAGE_HOMEPAGE_URL "https://ingescape.com")
  set(CPACK_PACKAGE_VENDOR "Ingenuity i/o")
  set(CPACK_PACKAGE_CONTACT "")
  set(CPACK_PACKAGE_VERSION ${VERSION})
  set(CPACK_STRIP_FILES TRUE)

  set(CPACK_SOURCE_IGNORE_FILES "${CMAKE_CURRENT_SOURCE_DIR}/.git/;${CMAKE_CURRENT_SOURCE_DIR}/build/")

  if (WIN32)
    # Installers for 32- vs. 64-bit CMake:
    #  - Root install directory (displayed to end user at installer-run time)
    #  - "NSIS package/display name" (text used in the installer GUI)
    #  - Registry key used to store info about the installation
    if(CMAKE_CL_64)
      set(CPACK_NSIS_INSTALL_ROOT "$PROGRAMFILES64")
      set(CPACK_NSIS_PACKAGE_NAME "${CPACK_PACKAGE_NAME} ${CPACK_PACKAGE_VERSION} (Win64)")
      set(CPACK_PACKAGE_INSTALL_REGISTRY_KEY "${CPACK_PACKAGE_NAME} (Win64)")
    else()
      set(CPACK_NSIS_INSTALL_ROOT "$PROGRAMFILES")
      set(CPACK_NSIS_PACKAGE_NAME "${CPACK_PACKAGE_NAME} ${CPACK_PACKAGE_VERSION}")
      set(CPACK_PACKAGE_INSTALL_REGISTRY_KEY "${CPACK_PACKAGE_NAME} (Win32)")
    endif()

    # On windows put all agents in ingescape directory
    set(CPACK_PACKAGE_INSTALL_DIRECTORY "ingescape")

    # NSIS configuration for Windows
    set(CPACK_NSIS_DISPLAY_NAME "First full agent")
    set(CPACK_NSIS_PACKAGE_NAME ${PROJECT_NAME})
    set(CPACK_NSIS_HELP_LINK "https://ingescape.com")
    set(CPACK_NSIS_CONTACT "contact@ingescape.com")

    set(CPACK_NSIS_ENABLE_UNINSTALL_BEFORE_INSTALL ON)
    set(CPACK_NSIS_MODIFY_PATH OFF)
    set(CPACK_NSIS_URL_INFO_ABOUT ${CMAKE_PROJECT_HOMEPAGE_URL})
    set(CPACK_MONOLITHIC_INSTALL ON)
    set(CPACK_GENERATOR "NSIS;ZIP")

  elseif ( ${CMAKE_SYSTEM_NAME} MATCHES "Darwin" )
    # Without component productbuild will not package any files
    set (CPACK_COMPONENTS_ALL agent)
    set(CPACK_PACKAGING_INSTALL_PREFIX "/usr/local")
    set(CPACK_PACKAGING_INSTALL_PREFIX "/usr/local")
    set(CPACK_SYSTEM_NAME "macos")
    set(CPACK_GENERATOR "productbuild;ZIP")

    configure_file("${CMAKE_CURRENT_SOURCE_DIR}/LICENSE" "${CMAKE_BINARY_DIR}/LICENSE.txt" COPYONLY)
    set(CPACK_RESOURCE_FILE_LICENSE "${CMAKE_BINARY_DIR}/LICENSE.txt")

  else ()
    set(CPACK_MONOLITHIC_INSTALL ON)
    install(FILES "${CMAKE_CURRENT_SOURCE_DIR}/packaging/unix/install_script.sh"
            DESTINATION "."
            PERMISSIONS OWNER_READ OWNER_EXECUTE GROUP_READ GROUP_EXECUTE WORLD_READ WORLD_EXECUTE
            COMPONENT agent)
    set(CPACK_GENERATOR "TGZ")
  endif ()

  include (CPack)
endif()

# ##############################################################################
# summary
# ##############################################################################
message("")
message(STATUS "******************* Configuration Summary *******************")
message(STATUS "General:")
message(STATUS "  Version           :   ${VERSION}")
message(STATUS "  System            :   ${CMAKE_SYSTEM_NAME}")
message(STATUS "  C compiler        :   ${CMAKE_C_COMPILER}")
message(
  STATUS "  Debug C flags     :   ${CMAKE_C_FLAGS_DEBUG} ${CMAKE_C_FLAGS}")
message(
  STATUS "  Release C flags   :   ${CMAKE_C_FLAGS_RELEASE} ${CMAKE_C_FLAGS}")
message(STATUS "  Build type        :   ${CMAKE_BUILD_TYPE}")
message(STATUS "")
message(STATUS "Dependencies:")
include(FeatureSummary)
feature_summary(WHAT ALL FATAL_ON_MISSING_REQUIRED_PACKAGES)
message(STATUS "")
message(STATUS "Install:")
message(STATUS "  Install prefix    :   ${CMAKE_INSTALL_PREFIX}")
message(STATUS "")
if(NOT MSVC)
  message(
    STATUS "*************************************************************")
  message(STATUS "Configuration complete! Now procced with:")
  message(STATUS "  'make'                compile the project")
  message(
    STATUS
      "  'make install'        install the project to ${CMAKE_INSTALL_PREFIX}")
  message(
    STATUS
      "  'make uninstall'      uninstall the project from ${CMAKE_INSTALL_PREFIX}"
    )
  if(CMAKE_BUILD_TYPE STREQUAL "Release")
    message(STATUS "  'make package'        Create library installer")
  endif()
endif()
message(STATUS "")

